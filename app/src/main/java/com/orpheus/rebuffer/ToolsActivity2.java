package com.orpheus.rebuffer;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.ArrayList;


public class ToolsActivity2 extends AppCompatActivity {

    RecyclerView mrecyclerView;
    RecyclerViewAdapter madapterRV;
    RecyclerView.LayoutManager mlayoutManagerRV;
    private ArrayList<String> mMasterTipe = new ArrayList<String>();
    private ArrayList<String> mMasterUkuran = new ArrayList<String>();
    private ArrayList<String> mMasterMerk = new ArrayList<String>();
    private ArrayList<String> mMasterBahan = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tools2);
        mMasterTipe.add("A");mMasterTipe.add("A");mMasterTipe.add("A");mMasterTipe.add("A");mMasterTipe.add("A");
        mMasterUkuran.add("B");mMasterUkuran.add("B");mMasterUkuran.add("B");mMasterUkuran.add("B");mMasterUkuran.add("B");
        mMasterMerk.add("C");mMasterMerk.add("C");mMasterMerk.add("C");mMasterMerk.add("C");mMasterMerk.add("C");mMasterMerk.add("C");
        mMasterBahan.add("D");mMasterBahan.add("D");mMasterBahan.add("D");mMasterBahan.add("D");mMasterBahan.add("D");mMasterBahan.add("D");

        UserData data = new UserData();
        data.fetchDataInventory(getApplicationContext());

        mrecyclerView = (RecyclerView) findViewById(R.id.a);
        mrecyclerView.setHasFixedSize(true);

        mlayoutManagerRV = new LinearLayoutManager(this);
        mrecyclerView.setLayoutManager(mlayoutManagerRV);

        madapterRV = new RecyclerViewAdapter(mMasterBahan,mMasterMerk,mMasterTipe,mMasterUkuran);
        mrecyclerView.setAdapter(madapterRV);

    }
}
