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
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

        UserData.fetchDataInventory(getApplicationContext());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                //Do something after 2s
                Log.d("MAP Entry", "onCreate: IM HERE");
                List<StringWithTag> itemList = new ArrayList<StringWithTag>();
                Log.d("MAP Entry", "onCreate: IM HERE AGAIN");
//                for (Map.Entry<String, String> entry : UserData.mapMerk.entrySet())
//                {
//                    Log.d("MAP Entry", "onCreate: IM HERE IN THE LOOP");
//                    String key = entry.getKey();
//                    String value = entry.getValue();
//                    Log.d("MAP Entry", "onCreate: " + key + '\t' + value);
//                    itemList.add(new StringWithTag(value, key));
//                    Log.d("MAP Entry", "onCreate: " + itemList.get(itemList.size() - 1).toString());
//
//                }
                String[] spinnerArray = new String[UserData.mapMerk.size()];
                Log.d("MAP Entry", "onCreate: IM HERE BEFORE THE LOOP");
                HashMap<Integer,String> spinnerMap = new HashMap<Integer,String>();
                Log.d("MAP Entry", "run: "+UserData.mapMerk.size());
                for (int i = 0; i < UserData.mapMerk.size(); i++)
                {
                    spinnerMap.put(i,UserData.mapMerk.get(i));
                    spinnerArray[i] = UserData.mapMerk.get(i);
                    Log.d("MAP Entry", "onCreate: IM HERE IN THE LOOP");
                }
                Log.d("MAP Entry", "onCreate: IM HERE AFTER THE LOOP");
                Spinner spinner = (Spinner) findViewById(R.id.spintest);
                ArrayAdapter<StringWithTag> spinnerAdapter = new ArrayAdapter<StringWithTag>(getApplicationContext(), android.R.layout.simple_spinner_item, itemList);
                spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinner.setAdapter(spinnerAdapter);
                Log.d("MAP ENTRY", "run: ME HERE AFTER ADAPTER");
                spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        StringWithTag swt = (StringWithTag) parent.getItemAtPosition(position);
                        String loadsearchkeyID = (String) swt.tag;

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
            }
        }, 5000);

    }

    private static class StringWithTag {
        public String string;
        public Object tag;

        public StringWithTag(String string, Object tag) {
            this.string = string;
            this.tag = tag;
        }

        @Override
        public String toString() {
            return string;
        }
    }


}
