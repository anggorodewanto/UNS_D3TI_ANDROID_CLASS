package com.example.nuriskandarz.jsonparsing;

        import android.util.JsonReader;
        import android.util.JsonToken;

        import org.json.JSONArray;
        import org.json.JSONException;
        import org.json.JSONObject;

        import java.io.IOException;
        import java.util.ArrayList;
        import java.util.List;

/**
 * A helper class that creates a {@link JSONObject} from a {@link JsonReader}.
 */
public final class JSONParser {

    public JSONParser() {}

    /**
     * Consumes and parses exactly one JSON object from the {@link JsonReader}.
     * The object's fields can only be objects, strings or arrays of strings.
     * @param reader
     */
    public static JSONObject parse(String reader) throws IOException, JSONException {
        JSONObject output = new JSONObject();
        String errorMsg = null;

        reader.beginObject();
        while (reader.hasNext()) {
            String fieldName = reader.nextName();

            if (output.has(fieldName)) {
                errorMsg = "Duplicate field name.";
                reader.skipValue();
                continue;
            }

            JsonToken token = reader.peek();
            if (token.equals(JsonToken.BEGIN_ARRAY)) {
                output.put(fieldName, new JSONArray(parseArray(reader)));
            } else if (token.equals(JsonToken.STRING)) {
                output.put(fieldName, reader.nextString());
            } else if (token.equals(JsonToken.BEGIN_OBJECT)) {
                try {
                    output.put(fieldName, parse(reader));
                } catch (JSONException e) {
                    errorMsg = e.getMessage();
                }
            } else {
                reader.skipValue();
                errorMsg = "Unsupported value type.";
            }
        }
        reader.endObject();

        if (errorMsg != null) {
            throw new JSONException(errorMsg);
        }

        return output;
    }

    /**
     * Parses one string array from the {@link JsonReader}.
     */
    public static List<String> parseArray(JsonReader reader) throws IOException {
        ArrayList<String> output = new ArrayList<>();

        reader.beginArray();
        while (reader.hasNext()) {
            output.add(reader.nextString());
        }
        reader.endArray();

        return output;
    }
}
