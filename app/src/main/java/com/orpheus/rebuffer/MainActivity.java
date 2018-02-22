package com.orpheus.rebuffer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
//*****-----Ini buat ganti ke page berikutnya-----*****//
    public void sendMessage(View view) {
        Intent intent = new Intent( MainActivity.this,ToolsActivity.class);
        startActivity(intent);
        finish();
    }
}
