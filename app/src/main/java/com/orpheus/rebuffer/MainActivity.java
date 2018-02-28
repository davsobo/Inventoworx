package com.orpheus.rebuffer;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.Map;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        UserData.fetchDataInventory(getApplicationContext());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Log.d("JSON TeST", "I'M HERE");
                Log.d("JSON TEST", UserData.mapInventory.toString());
                for (Map.Entry<String, Map<String,String>> entry : UserData.mapInventory.entrySet())
                {
                    String key = entry.getKey();
                    Log.d("Json Response: Main", "key = " + key);
                    for(Map.Entry<String,String> entry1: entry.getValue().entrySet() )
                    {
                        Log.d("Json Response: Main", entry1.getValue());
                    }
                }
            }
        },2000);

    }

    //*****-----Ini buat ganti ke page berikutnya-----*****//
    public void sendMessage(View view) {
        Intent intent = new Intent(MainActivity.this, ToolsActivity.class);
        startActivity(intent);
        finish();
    }
}
