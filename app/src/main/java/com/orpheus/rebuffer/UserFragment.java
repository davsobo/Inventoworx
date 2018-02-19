package com.orpheus.rebuffer;

import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;

/**
 * Created by David on 2/17/2018.
 */

public class UserFragment extends ListFragment{

//    private EditText;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);
        return view;
    }

//    @Override
//    public void onActivityCreated (Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity()),
//                R.array.
//    }
}
