package liat.liat.loe.comape.fb.praktikum8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity (
private static final String TAG = "http connection";
private ListView ListView = null;
private ArrayAdapter arrayAdapter = null;
private String[] blogTitles;

@Override
protected void onCreate(Bundle save InstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.Layout.activity_main);
        ListView = (ListView) findViewById(R.id.listView);
final String url = "http://javateching.com/api/get_categoory_posts/?dev=l&slug=android";
        new AsynchttpTask().execute(url);
        }
        }

public class AsynchttpTask extends AsyncTask<String, Void, Integer>
        @Override
        protected Integer doInBackground(String... params){
            InpusStream inputStream=null;
            Integer result = 0;
            try {
                URL url = new URL(params(0));
                urlConnection urlConnection = (httpURLConnection) url.openConnection();
                urlConnection.setRequestProperty("Content-Type","appLication/json");
                urlConnection.setRequestMethod("GET");
                in statusCode = urlConnection.getResponsCode();
                if(statusCode = 200) {
                    inputStream= new BufferedInputStream(urlConnection.getInputStream());
                    String response = convertInputStreamToString(inputStream);
                    parseResult=response);
                    result=1;
                } else {
                    result = 0;
                }
            }catch (Exeption e) {
                Log.d(TAG, e.getLocallizedMessage());
            }
            return result;
        }
            @Ovverude
protected void onPostExecute(Integer result) {
                if (result == 1) {
                    arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.Layout.simple_list_item_1, blogTitles);
                    ListView.setAdapter(arrayAdapter);
                } else {
                    log.e(TAG, "Failed to fetch data!");
                }
            }


}
private String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader( new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while((line - bufferedReader.readLine()) != null){
            result +=line;
        }
        if(null!-inputStream){
            inputStream.close();
        }
        return result;
        }
private void parseResult(String result){
        try{
        JSONObject response=new JSNONObject(resul);
        JSONArray posts=response.opJSONArray("posts");
        blogTitles=new String[posts.length()];
        for(int i=0;i<posts.lenght();i++){
        JSONObject post=posts.opJSONObject(i);
        String title=post.opString("title");
        blogTiltes[i]=title;
        }
        }catch (JSONExeption e){
            e.printStackTrace();
        }
        }
        }