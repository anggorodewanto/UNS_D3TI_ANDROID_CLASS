package com.example.asus8.webbrowser;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends Activity {
    /** Called when the activity is first created. */
    private WebView webBrowserKu;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Mengeset webView sebagai layout utama
        webBrowserKu= (WebView) findViewById(R.id.web_view);
        //memanggil method openBrowser #youdontsay
        openBrowser();
        WebSettings theWebSetting = webBrowserKu.getSettings();
        theWebSetting.setJavaScriptEnabled(true);
    }

    //karena ada method static yang diakses oleh method non-static (openBrowser)
    @SuppressWarnings("static-access")
    private void openBrowser() {
        //memanggil URL www.twoh.web.id
        String url = "http://www.facebook.com";

        //Menginstantiasi webchrome client baru)
        WebChromeClient wcc = new WebChromeClient();
        webBrowserKu.setWebChromeClient(wcc);
        //mengaktifkan javascript, kalo nggak aktif... TRY IT!
        webBrowserKu.getSettings().setJavaScriptEnabled(true);
        //mengaktifkan built in zoom controls
        webBrowserKu.getSettings().setBuiltInZoomControls(true);
        //bagian ini akan dijelaskan
        //webBrowserKu.enablePlatformNotifications();
        //meload URL
        webBrowserKu.loadUrl(url);
    }

}
