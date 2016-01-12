package com.example.alone.json;

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

import org.json.JSONArray;
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

    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn1=(Button) findViewById(R.id.tombol);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checknternetConnection();
                GetData dataambil = new GetData();
                dataambil.kata_tunggu = "Loading";
                dataambil.execute();
            }
        });
    }

    private String DownloadText(String s) {
        int BUFFER_SIZE = 2000;
        InputStream in = null;
        in = openHttpConnection(s);
        InputStreamReader isr = new InputStreamReader(in);
        int charRead;
        String str = "";
        char[] inputBuffer = new char[BUFFER_SIZE];
        try {
            while ((charRead = isr.read(inputBuffer))>0)
            {
                String readString = String.copyValueOf(inputBuffer, 0, charRead);
                str += readString;
                inputBuffer = new char[BUFFER_SIZE];
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
        return str;
    }

    private InputStream openHttpConnection(String s){
        InputStream in = null;
        int resCode = -1;

        try {
            URL url = new URL(s);
            URLConnection urlConnection = url.openConnection();

            if (!(urlConnection instanceof HttpURLConnection)){
                throw new IOException("URL is not an Http URL");
            }
            HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
            httpURLConnection.setAllowUserInteraction(false);
            httpURLConnection.setInstanceFollowRedirects(true);
            httpURLConnection.setRequestMethod("GET");
            httpURLConnection.connect();
            resCode=httpURLConnection.getResponseCode();
            if (resCode== HttpURLConnection.HTTP_OK){
                in=httpURLConnection.getInputStream();
            }
        }
        catch (MalformedURLException e){
            e.printStackTrace();
        }
        catch (IOException e){
            e.printStackTrace();
        }
        return in;
    }
    private class GetData extends AsyncTask<String, Void, String> {
        ProgressDialog dialog = new ProgressDialog(MainActivity.this);
        String kata_tunggu;
        String hasilData;
        @Override
        protected String doInBackground(String... params) {
            String urlnya = "http://192.168.137.1:81/tambalban/getdata.php";
            hasilData = DownloadText(urlnya);
            return null;
        }
        @Override
        protected void onPreExecute() {
            this.dialog.setMessage(kata_tunggu);
            this.dialog.show();
        }
        @Override
        protected void onPostExecute(String result) {
            Button parse = (Button)findViewById(R.id.tombol2);
            final TextView kata = (TextView) findViewById(R.id.text1);
            kata.setText(hasilData);
            parse.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    kata.setText("");
                    TextView isp = (TextView) findViewById(R.id.isp);
                    TextView country = (TextView) findViewById(R.id.country);
                    TextView city = (TextView) findViewById(R.id.city);
                    TextView ip = (TextView) findViewById(R.id.ip);
                    String TAG_ISP = "tb_ID";
                    String TAG_COUNTRY = "country";
                    String TAG_CITY = "city";
                    String TAG_IP = "query";
                    JSONArray jsonArray = null;
                    JSONObject json = null;
                    try {
                        jsonArray = new JSONArray(hasilData);
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    for (int i = 0; i < jsonArray.length(); i++){
                        try {
                            json = jsonArray.getJSONObject(i);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                    try {
                        isp.setText("ISP : " + json.getString(TAG_ISP));
                        //country.setText("COUNTRY : " + json.getString(TAG_COUNTRY));
                        //city.setText("CITY : " + json.getString(TAG_CITY));
                        //ip.setText("IP : " + json.getString(TAG_IP));
                    } catch (JSONException e) {
                        // TODO: handle exception
                        e.printStackTrace();
                    }
                }
            });
            this.dialog.dismiss();
        }
    }

    private boolean checknternetConnection(){
        ConnectivityManager connec = (ConnectivityManager)getSystemService(getBaseContext().CONNECTIVITY_SERVICE);
        if(connec.getNetworkInfo(0).getState()== NetworkInfo.State.CONNECTED||
                connec.getNetworkInfo(0).getState()==NetworkInfo.State.CONNECTING||
                connec.getNetworkInfo(1).getState()==NetworkInfo.State.CONNECTED||
                connec.getNetworkInfo(1).getState()==NetworkInfo.State.CONNECTING){
            Toast.makeText(this, "Connected", Toast.LENGTH_LONG).show();
            return true;
        }
        else if(connec.getNetworkInfo(0).getState()== NetworkInfo.State.DISCONNECTED||
                connec.getNetworkInfo(1).getState()== NetworkInfo.State.DISCONNECTED){
            Toast.makeText(this,"Not Connected",Toast.LENGTH_LONG).show();
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
