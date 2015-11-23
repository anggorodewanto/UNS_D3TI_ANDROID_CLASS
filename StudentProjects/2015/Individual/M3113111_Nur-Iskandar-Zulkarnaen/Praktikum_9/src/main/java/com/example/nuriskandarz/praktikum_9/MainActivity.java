package com.example.nuriskandarz.praktikum_9;


import android.app.Activity;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.net.URL;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button  bl = (Button) findViewById(R.id.tombol);

        final TextView output = (TextView) findViewById(R.id.tampil);

		bl.setOnClickListener(new View.OnClickListener() {
           @Override
            public void onClick(View v) {
                checkInternetConnection();
                JsonParsing js = new JsonParsing();

                String jsonStr =js.getJSON("http://ip-api.com/json");

                Log.d("Response: ", "> " + jsonStr);

                if (jsonStr != null) {

                    String data = "";
                    try {
                        JSONObject  jsonRootObject = new JSONObject(jsonStr);

                           // int id = Integer.parseInt(jsonRootObject.optString("id").toString());

                            String as = jsonRootObject.optString("as").toString();

                            String city = jsonRootObject.getString("city");
                            String country = jsonRootObject.getString("country");
                            String countryCode = jsonRootObject.getString("countryCode");
                            String isp = jsonRootObject.getString("isp");
                            float lat = Float.parseFloat(jsonRootObject.optString("lat").toString());
                            float lon = Float.parseFloat(jsonRootObject.optString("lon").toString());
                            String org = jsonRootObject.getString("org");
                            String query = jsonRootObject.getString("query");
                            String region = jsonRootObject.getString("region");
                            String regionName = jsonRootObject.getString("regionName");
                            String status = jsonRootObject.getString("status");
                            String timezone = jsonRootObject.getString("timezone");
                            String zip = jsonRootObject.getString("zip");


                            data += "as "+as
                                    +" \n city= "+city
                                    +" \n country= "+ country
                                    +" \n countryCode = "+ countryCode
                                    +" \n isp = "+ isp
                                    +" \n lat= "+lat
                                    +" \n lon= "+ lon
                                    +" \n org = "+ org
                                    +" \n query = "+ query
                                    +" \n region = "+ region
                                    +" \n regionName= "+regionName
                                    +" \n status= "+ status
                                    +" \n timezone = "+ timezone
                                    +" \n zip = "+ zip
                                    +" \n ";
                        output.setText(data);
                    } catch (JSONException e) {e.printStackTrace();}

                } else {
                    Log.e("ServiceHandler", "Couldn't get any data from the url");
                }

			class JSONtask extends AsyncTask<URL,String,String>{

			}
                
			}


		});
    }





    private boolean checkInternetConnection(){
        ConnectivityManager connec = (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        if(connec.getNetworkInfo(0).getState()== NetworkInfo.State.CONNECTED||
                connec.getNetworkInfo(0).getState()==NetworkInfo.State.CONNECTING||
                connec.getNetworkInfo(1).getState()==NetworkInfo.State.CONNECTING||
                connec.getNetworkInfo(1).getState()==NetworkInfo.State.CONNECTED){
            Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();
            return true;
        }else if(
                connec.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                        connec.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED ){
            Toast.makeText(this,"Not Connected", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }

}



