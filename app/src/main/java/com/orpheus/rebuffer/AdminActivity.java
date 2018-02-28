package com.orpheus.rebuffer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class AdminActivity extends AppCompatActivity {

    private TextView uname;
    public Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6;
    private ArrayList<Spinner> spinnerCollection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        spinnerCollection = new ArrayList<Spinner>();
        spinner1 = (Spinner) findViewById(R.id.spinner);
        spinner2 = (Spinner) findViewById(R.id.spinner2);
        spinner3 = (Spinner) findViewById(R.id.spinner3);
        spinner4 = (Spinner) findViewById(R.id.spinner4);
        spinner5 = (Spinner) findViewById(R.id.spinner5);
        spinner6 = (Spinner) findViewById(R.id.spinner6);
        spinnerCollection.add(spinner1);
        spinnerCollection.add(spinner2);
        spinnerCollection.add(spinner3);
        spinnerCollection.add(spinner4);
        spinnerCollection.add(spinner5);
        spinnerCollection.add(spinner6);

        uname = (TextView) findViewById(R.id.adminNama);
        uname.setText(UserData.getmEmail());

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this, R.array.sample, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        for (Spinner spinner : spinnerCollection
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
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                /**-------ini jatahnya spinner1-------**/
                //Do something after 2s
                Log.d("RMAP Entry", "onCreate: IM HERE");
                String[] spinnerArray1 = new String[UserData.mapMerk.size()];
                Log.d("RMAP Entry", "onCreate: IM HERE BEFORE THE LOOP");
                HashMap<Integer,String> spinnerMap1 = new HashMap<Integer, String>();
                Log.d("RMAP Entry", "run: "+UserData.mapMerk.size());
                for (int i = 0; i < UserData.mapMerk.size(); i++)
                {
                    spinnerMap1.put(i,UserData.mapMerk.get(i));
                    spinnerArray1[i] = UserData.mapMerk.get(i);
                    Log.d("RMAP Entry", "onCreate: IM HERE IN THE LOOP");
                }
                Log.d("RMAP Entry", "onCreate: IM HERE AFTER THE LOOP");
                ArrayAdapter<String> spinnerAdapter1 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray1);
                spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner1.setAdapter(spinnerAdapter1);
                Log.d("RMAP ENTRY", "run: ME HERE AFTER ADAPTER");

                /**------ini jatahnya spinner 2-------**/
                Log.d("RMAP Entry", "onCreate: IM HERE");
                String[] spinnerArray2 = new String[UserData.mapTipe.size()];
                Log.d("RMAP Entry", "onCreate: IM HERE BEFORE THE LOOP");
                HashMap<Integer,String> spinnerMap2 = new HashMap<Integer, String>();
                Log.d("RMAP Entry", "run: "+UserData.mapTipe.size());
                for (int i = 0; i < UserData.mapTipe.size(); i++)
                {
                    spinnerMap2.put(i,UserData.mapTipe.get(i));
                    spinnerArray2[i] = UserData.mapTipe.get(i);
                    Log.d("RMAP Entry", "onCreate: IM HERE IN THE LOOP");
                }
                Log.d("RMAP Entry", "onCreate: IM HERE AFTER THE LOOP");
                ArrayAdapter<String> spinnerAdapter2 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray2);
                spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner2.setAdapter(spinnerAdapter2);
                Log.d("RMAP ENTRY", "run: ME HERE AFTER ADAPTER");

                /**------ini jatahnya spinner3------**/
                Log.d("RMAP Entry", "onCreate: IM HERE");
                String[] spinnerArray3 = new String[UserData.mapUkuran.size()];
                Log.d("RMAP Entry", "onCreate: IM HERE BEFORE THE LOOP");
                HashMap<Integer,String> spinnerMap3 = new HashMap<Integer, String>();
                Log.d("RMAP Entry", "run: "+UserData.mapUkuran.size());
                for (int i = 0; i < UserData.mapUkuran.size(); i++)
                {
                    spinnerMap3.put(i,UserData.mapUkuran.get(i));
                    spinnerArray3[i] = UserData.mapUkuran.get(i);
                    Log.d("RMAP Entry", "onCreate: IM HERE IN THE LOOP");
                }
                Log.d("RMAP Entry", "onCreate: IM HERE AFTER THE LOOP");
                ArrayAdapter<String> spinnerAdapter3 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray3);
                spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner3.setAdapter(spinnerAdapter3);
                Log.d("RMAP ENTRY", "run: ME HERE AFTER ADAPTER");

                /**------ini jatahnya spinner4------**/
                Log.d("RMAP Entry", "onCreate: IM HERE");
                String[] spinnerArray4 = new String[UserData.mapBahan.size()];
                Log.d("RMAP Entry", "onCreate: IM HERE BEFORE THE LOOP");
                HashMap<Integer,String> spinnerMap4 = new HashMap<Integer, String>();
                Log.d("RMAP Entry", "run: "+UserData.mapBahan.size());
                for (int i = 0; i < UserData.mapBahan.size(); i++)
                {
                    spinnerMap4.put(i,UserData.mapBahan.get(i));
                    spinnerArray4[i] = UserData.mapBahan.get(i);
                    Log.d("RMAP Entry", "onCreate: IM HERE IN THE LOOP");
                }
                Log.d("RMAP Entry", "onCreate: IM HERE AFTER THE LOOP");
                ArrayAdapter<String> spinnerAdapter4 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray4);
                spinnerAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner4.setAdapter(spinnerAdapter4);
                Log.d("RMAP ENTRY", "run: ME HERE AFTER ADAPTER");

                /**------ini jatahnya spinner5------**/
                Log.d("RMAP Entry", "onCreate: IM HERE");
                String[] spinnerArray5 = new String[UserData.mapJumlah.size()];
                Log.d("RMAP Entry", "onCreate: IM HERE BEFORE THE LOOP");
                HashMap<Integer,String> spinnerMap5 = new HashMap<Integer, String>();
                Log.d("RMAP Entry", "run: "+UserData.mapJumlah.size());
                for (int i = 0; i < UserData.mapJumlah.size(); i++)
                {
                    spinnerMap5.put(i,UserData.mapJumlah.get(i));
                    spinnerArray5[i] = UserData.mapJumlah.get(i);
                    Log.d("RMAP Entry", "onCreate: IM HERE IN THE LOOP");
                }
                Log.d("RMAP Entry", "onCreate: IM HERE AFTER THE LOOP");
                ArrayAdapter<String> spinnerAdapter5 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray5);
                spinnerAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner5.setAdapter(spinnerAdapter5);
                Log.d("RMAP ENTRY", "run: ME HERE AFTER ADAPTER");

                /**------ini jatahnya spinner6------**/
                Log.d("RMAP Entry", "onCreate: IM HERE");
                String[] spinnerArray6 = new String[UserData.mapLokasi.size()];
                Log.d("RMAP Entry", "onCreate: IM HERE BEFORE THE LOOP");
                HashMap<Integer,String> spinnerMap6 = new HashMap<Integer, String>();
                Log.d("RMAP Entry", "run: "+UserData.mapLokasi.size());
                for (int i = 0; i < UserData.mapLokasi.size(); i++)
                {
                    spinnerMap6.put(i,UserData.mapLokasi.get(i));
                    spinnerArray6[i] = UserData.mapLokasi.get(i);
                    Log.d("RMAP Entry", "onCreate: IM HERE IN THE LOOP");
                }
                Log.d("RMAP Entry", "onCreate: IM HERE AFTER THE LOOP");
                ArrayAdapter<String> spinnerAdapter6 = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerArray6);
                spinnerAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner6.setAdapter(spinnerAdapter6);
                Log.d("RMAP ENTRY", "run: ME HERE AFTER ADAPTER");
            }
        }, 1000);
    }
}
