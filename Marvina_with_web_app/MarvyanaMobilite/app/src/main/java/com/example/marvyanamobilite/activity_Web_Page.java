package com.example.marvyanamobilite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class activity_Web_Page extends AppCompatActivity {

    private WebView myWebView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity__web__page);

        myWebView2 = (WebView)findViewById(R.id.Web_App_button);
        WebSettings webSettings = myWebView2.getSettings();
        webSettings.setJavaScriptEnabled(true);
        myWebView2.loadUrl("https://www.epsi.fr/");
        myWebView2.setWebViewClient(new WebViewClient());
    }

    @Override
    public void onBackPressed() {
        if(myWebView2.canGoBack()){
            myWebView2.goBack();
        } else {
            super.onBackPressed();
        }

    }
}