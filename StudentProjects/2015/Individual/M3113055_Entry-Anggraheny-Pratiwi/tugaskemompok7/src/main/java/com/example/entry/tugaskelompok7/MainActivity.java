package com.example.entry.tugaskelompok7;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends Activity {
    private static final String TAG = "Http Connection";
    private ListView listView = null;
    private ArrayAdapter arrayAdapter = null;
    private String[] blogTitles;
    Button b1;
    EditText edittext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.button);
        listView = (ListView) findViewById(R.id.listView);
        edittext = (EditText) findViewById(R.id.editText);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String keyword= edittext.getText().toString();
                String url = "http://javatechig.com/api/get_category_posts/?dev=1&slug="+keyword;
                new AsyncHttpTask().execute(url);
            }
        });

    }


    public class AsyncHttpTask extends AsyncTask<String, Void, Integer> {
        @Override
        protected Integer doInBackground(String... params) {
            InputStream inputStream = null;
            HttpURLConnection urlConnection = null;
            Integer result = 0;
            try {
              
                URL url = new URL(params[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                
                urlConnection.setRequestProperty("Content-Type", "application/json");
               
                urlConnection.setRequestProperty("Accept", "application/json");
            
                urlConnection.setRequestMethod("GET");
                int statusCode = urlConnection.getResponseCode();
              
                if (statusCode ==  200) {
                    inputStream = new BufferedInputStream(urlConnection.getInputStream());
                    String response = convertInputStreamToString(inputStream);
                    parseResult(response);
                    result = 1; 
                }else{
                    result = 0; 
                }
            } catch (Exception e) {
                Log.d(TAG, e.getLocalizedMessage());
            }
            return result; 
        }


        @Override
        protected void onPostExecute(Integer result) {
            
            if(result == 1){
                arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1, blogTitles);
                listView.setAdapter(arrayAdapter);
            }else{
                Log.e(TAG, "Failed to fetch data!");
            }
        }
    }


    private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line = bufferedReader.readLine()) != null){
            result += line;
        }
           
        if(null!=inputStream){
            inputStream.close();
        }
        return result;
    }
    private void parseResult(String result) {
        try{
            JSONObject response = new JSONObject(result);
            JSONArray posts = response.optJSONArray("posts");
            blogTitles = new String[posts.length()];
            for(int i=0; i< posts.length();i++ ){
                JSONObject post = posts.optJSONObject(i);
                String title = post.optString("title");
                blogTitles[i] = title;
            }
        }catch (JSONException e){
            e.printStackTrace();
        }
    }
}
