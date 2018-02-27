package com.orpheus.rebuffer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AdminActivity extends AppCompatActivity {

    private TextView uname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        uname= (TextView) findViewById(R.id.adminNama);
        uname.setText(UserData.getmEmail());
    }
}
