package com.example.shoji.hybridsample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class NativeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_native);
    }

    public void onHomeButtonClick(View view){
        Intent intent = new Intent();
        intent.putExtra("INPUT_STRING", "This is ホーム画面");
        setResult(RESULT_OK, intent);
        finish();
    }

    public void onSettingButtonClick(View view){
        Intent intent = new Intent();
        intent.putExtra("INPUT_STRING", "This is 設定画面");
        setResult(RESULT_OK, intent);
        finish();
    }
}
