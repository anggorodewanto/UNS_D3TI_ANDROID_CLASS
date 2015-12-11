package com.example.bella.praktikum_9;

import android.app.Activity;
import android.app.ProgressDialog;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class MainActivity extends Activity {

    Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button1 = (Button) findViewById(R.id.btn1);
        button1.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                checkInternetConnection();
                GetData ambildata = new GetData();
                ambildata.waiting = "Loading";
                ambildata.execute();
            }
        });
    }

    private String DownloadText(String text){
        int BUFFER_SIZE = 2000;
        InputStream input = null;
        input = openHttpConnection(text);
        InputStreamReader inputStreamRead = new InputStreamReader(input);
        int charRead;
        String str = "";
        char[] inputBuffer = new char[BUFFER_SIZE];
        try{
            while((charRead = inputStreamRead.read(inputBuffer))>0){
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            input.close();
        }catch (IOException e){
            e.printStackTrace();
            return "";
        }
        return str;
    }

    private InputStream openHttpConnection(String text){
        InputStream input = null;
        int resCode = -1;

        try{
            URL url = new URL(text);
            URLConnection urlConnection = url.openConnection();

            if (!(urlConnection instanceof HttpURLConnection)){
                throw new IOException("URL is not a HTTP URL");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            resCode = httpURLConnection.getResponseCode();
            if (resCode == httpURLConnection.HTTP_OK) {
                input = httpURLConnection.getInputStream();
            }
        }catch (MalformedURLException e) {
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }
        return input;
    }

    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog progress = new ProgressDialog(MainActivity.this);
        String waiting;
        String hasilData;
        TextView isp = (TextView) findViewById(R.id.isp);
        TextView country = (TextView) findViewById(R.id.country);
        TextView city = (TextView) findViewById(R.id.city);
        TextView ipaddress = (TextView) findViewById(R.id.ip);

        @Override
        protected String doInBackground(String... params) {
            String urls = "http://ip-api.com/json";
            hasilData = DownloadText(urls);
            return null;
        }

        @Override
        protected void onPreExecute() {
            this.progress.setMessage(waiting);
            this.progress.show(); 
        }

        @Override
        protected void onPostExecute(String result) {
            Button parse = (Button) findViewById(R.id.btn2);
            final TextView text = (TextView) findViewById(R.id.text1);
            text.setText(hasilData);
            isp.setText(" ");
            country.setText(" ");
            city.setText(" ");
            ipaddress.setText(" ");
            parse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    text.setText("");
                    String TAG_ISP = "isp";
                    String TAG_COUNTRY = "country";
                    String TAG_CITY = "city";
                    String TAG_IPADDRESS = "query";
                    JSONObject json = null;
                    try {
                        json = new JSONObject(hasilData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                    try {
                        isp.setText("ISP : " + json.getString(TAG_ISP));
                        country.setText("Country : " + json.getString(TAG_COUNTRY));
                        city.setText("City : " + json.getString(TAG_CITY));
                        ipaddress.setText("IP Address : " + json.getString(TAG_IPADDRESS));
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            });
            this.progress.dismiss();
        }
    }

    private boolean checkInternetConnection(){
        ConnectivityManager connect = (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);

        if (connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTED ||
                connect.getNetworkInfo(0).getState() == NetworkInfo.State.CONNECTING ||
                connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTED ||
                connect.getNetworkInfo(1).getState() == NetworkInfo.State.CONNECTING){
            Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();
            return true;
        }else if(connect.getNetworkInfo(0).getState() == NetworkInfo.State.DISCONNECTED ||
                connect.getNetworkInfo(1).getState() == NetworkInfo.State.DISCONNECTED){
            Toast.makeText(this, "Not Connected", Toast.LENGTH_LONG).show();
            return false;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}