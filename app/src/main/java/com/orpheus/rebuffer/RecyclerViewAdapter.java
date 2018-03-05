package com.orpheus.rebuffer;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;

import java.util.ArrayList;

/**
 * Created by David on 3/3/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {
    private UserData mUserData;
    private ArrayList<String> mBahan = new ArrayList<String>();
    private ArrayList<String>mMerk = new ArrayList<String>();
    private ArrayList<String> mTipe = new ArrayList<String>();
    private ArrayList<String> mUkuran = new ArrayList<String>();

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public RelativeLayout mLayout;
        public Spinner spinner1, spinner2, spinner3, spinner4, spinner5, spinner6;

        public ViewHolder(RelativeLayout v) {
            super(v);
            mLayout = v;
            spinner1 = v.findViewById(R.id.spinner);
            spinner2 = v.findViewById(R.id.spinner2);
            spinner3 = v.findViewById(R.id.spinner3);
            spinner4 = v.findViewById(R.id.spinner4);
            spinner5 = v.findViewById(R.id.spinner5);
            spinner6 = v.findViewById(R.id.spinner6);
        }
    }

//    public RecyclerViewAdapter(UserData userData) {
//        mUserData = userData;
//    }
    public RecyclerViewAdapter(ArrayList<String> mMasterBahan,ArrayList<String>mMasterMerk,ArrayList<String> mMasterTipe,ArrayList<String> mMasterUkuran) {
        this.mBahan = mMasterBahan;
        this.mMerk = mMasterMerk;
        this.mTipe = mMasterTipe;
        this.mUkuran = mMasterUkuran;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view
        RelativeLayout layout = (RelativeLayout) LayoutInflater.from(parent.getContext())
                .inflate(R.layout.inventory_cell, parent, false);
        ViewHolder vh = new ViewHolder(layout);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element

        setSpinnerData(holder.spinner1, this.mMerk);
        setSpinnerData(holder.spinner2, this.mTipe);
        setSpinnerData(holder.spinner3, this.mUkuran);
        setSpinnerData(holder.spinner4, this.mBahan);
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return 1;
    }

    public void setSpinnerData(Spinner spinner, ArrayList<String>spinnerData) {
        ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<String>(spinner.getContext(), android.R.layout.simple_spinner_item, spinnerData);
        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(spinnerAdapter);
    }
}