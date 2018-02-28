package com.orpheus.rebuffer;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("JSON MAINACTIVITY", "Try WebView");
        WebView myWebView = (WebView) findViewById(R.id.webview);
        Log.d("JSON MAINACTIVITY", "Make WebView");
        WebSettings webSettings = myWebView.getSettings();
        Log.d("JSON MAINACTIVITY", "Make WebSetting");
        webSettings.setJavaScriptEnabled(true);
        Log.d("JSON MAINACTIVITY", "Try JavaScript");
        myWebView.setWebViewClient(new WebViewClient()
        {
            @Override
           public void onPageFinished(WebView view, String url)
           {
               Log.d("JSON OPF", "onPageFinished: "+url);
               DBConnection.setCOOKIE(getCookie("http://invento.html-5.me/","__test"));
               Log.d("JSON COOKIE", DBConnection.COOKIE);
           }
        });
        Log.d("JSON MAINACTIVITY", "SetChromeClient");
        myWebView.loadUrl("http://invento.html-5.me/login.php");
        Log.d("JSON MAINACTIVITY", "Try Load URL");
        //DBConnection.setCOOKIE(getCookie("http://invento.html-5.me/","__test"));

    }

    //*****-----Ini buat ganti ke page berikutnya-----*****//
    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public String getCookie(String siteName,String CookieName){
        String CookieValue = null;
        CookieManager cookieManager = CookieManager.getInstance();
        //cookieManager.removeAllCookies(null);
        String cookies = cookieManager.getCookie(siteName);
        String[] temp=cookies.split(";");
        for (String ar1 : temp ){
            if(ar1.contains(CookieName)){
                String[] temp1=ar1.split("=");
                CookieValue = temp1[1];
                break;
            }
        }
        return CookieValue;
    }
}
