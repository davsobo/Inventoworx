package com.orpheus.rebuffer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class ToolsActivity extends AppCompatActivity {

    private TextView uname;
    public Spinner spinner1;
    public Spinner spinner2;
    public Spinner spinner3;
    public Spinner spinner4;
    private ArrayList<Spinner> spinnerCollection ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools);

        spinnerCollection = new ArrayList<Spinner>();
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinnerCollection.add(spinner1);
        spinnerCollection.add(spinner2);
        spinnerCollection.add(spinner3);
        spinnerCollection.add(spinner4);

        uname = (TextView) findViewById(R.id.userNama);
        uname.setText(UserData.getmEmail());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.sample, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (Spinner spinner :spinnerCollection
             ) {
            spinner.setAdapter(adapter);
            spinner.setOnItemSelectedListener(
                    new AdapterView.OnItemSelectedListener() {
                        public void onItemSelected(
                                AdapterView<?> parent, View view, int position, long id) {
                        }

                        public void onNothingSelected(
                                AdapterView<?> parent) {
                        }
                    });

        }

    }
}
