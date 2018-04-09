package com.example.shoji.hybridsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        WebView webView = findViewById(R.id.webView);
        webView.setWebViewClient(new WebViewClient());
        webView.loadUrl("file:///android_asset/index.html");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebChromeClient(new WebChromeClient() {
            @Override
            public boolean onJsAlert(WebView view, String url, String message, JsResult result) {
                if (message.equals("tappedMenuButton()")) {
                    startNativeActivity();
                    result.confirm();
                    return true;
                } else {
                    return false;
                }
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
            case (REQUEST_CODE):
                if (resultCode == RESULT_OK) {
                    //OKボタンを押して戻ってきたときの処理
                    String text = data.getStringExtra("INPUT_STRING");
                    WebView webView = findViewById(R.id.webView);
                    webView.loadUrl("javascript:changeDisplay('" + text + "');");
                } else if (resultCode == RESULT_CANCELED) {
                    //キャンセルボタンを押して戻ってきたときの処理
                } else {
                    //その他
                }
                break;
            default:
                break;
        }
    }

    protected void startNativeActivity(){
        Intent intent = new Intent(this, NativeActivity.class);
        startActivityForResult( intent, REQUEST_CODE );
    }
}
