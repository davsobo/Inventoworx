package com.orpheus.rebuffer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ToolsActivity extends AppCompatActivity {

    private TextView uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);
        uname= (TextView) findViewById(R.id.usernama);
        uname.setText(LoginActivity.mEmail);
    }
}
