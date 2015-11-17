package com.example.nuriskandarz.jsonparsing;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

/**
 * Created by Nur Iskandar Z on 15/11/2015.
 */
public class TampilData extends AppCompatActivity {
    //simpan semua JSON node name ke dalam variabel
    private static final String TAG_TOILETS = "toilets";
    private static final String TAG_NAME = "name";
    private static final String TAG_TOILET_ID = "toilet_id";
    private static final String TAG_TYPE = "type";
    private static final String TAG_LATITUDE = "latitude";
    private static final String TAG_LONGITUDE = "longitude";
    private static final String url = "http://deaven.bl.ee/data.php";
    JSONArray toilets = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tampil_data);
        panggildata();
    }

    //method pemanggilan data
    public void panggildata() throws IOException, JSONException {
        //Membuat instance JSON Parser
        JSONParser jParser = new JSONParser();

        //mengambil JSON String dari url
        JSONObject json = jParser.parse(url);

        try{
            //mengambil array toilets
            toilets = json.getJSONArray(TAG_TOILETS);
            //loop pada toilets
            for(int i=0; i<toilets.length();i++)
            {
                //mengambil seluruh JSONObject toilets
                JSONObject a = toilets.getJSONObject(i);
                //simpan di variable String
                String toilet_id = a.getString(TAG_TOILET_ID);
                String name = a.getString(TAG_NAME);
                String type = a.getString(TAG_TYPE);
                String latitude = a.getString(TAG_LATITUDE);
                String longitude = a.getString(TAG_LONGITUDE);
                //tampilkan pada eclipse console
                Log.e("name", name);
            }
        }catch(JSONException e)
        {
            e.printStackTrace();
        }

    }

}
