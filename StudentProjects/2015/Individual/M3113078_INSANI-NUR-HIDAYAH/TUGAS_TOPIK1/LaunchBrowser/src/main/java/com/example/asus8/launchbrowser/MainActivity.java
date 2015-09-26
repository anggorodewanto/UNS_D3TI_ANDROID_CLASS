package com.example.asus8.launchbrowser;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
    String theUrl = "";
    public WebView webBrowserKu;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //loading setelah activity_main.xml terloading
        webBrowserKu = (WebView)findViewById(R.id.myWebView);
        //kita ingin supaya setiap link yang di click ditampilkan di WebView
        webBrowserKu.setWebViewClient(new WebViewClient());
        //enable kan Javascript
        WebSettings theWebSetting = webBrowserKu.getSettings();
        theWebSetting.setJavaScriptEnabled(true);
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

    public void gotoUrl(View view) {
        EditText theEditText = (EditText)findViewById(R.id.urlTxt);
        theUrl = theEditText.getText().toString();
        //
        webBrowserKu.loadUrl(theUrl);

    }

    public void goRefresh(MenuItem item) {
        webBrowserKu.reload();
    }

    public void goStop(MenuItem item) {
        webBrowserKu.stopLoading();
    }

    public void goBack(MenuItem item) {
        webBrowserKu.goBack();
    }

    public void goForward(MenuItem item) {
        webBrowserKu.goForward();
    }
}
