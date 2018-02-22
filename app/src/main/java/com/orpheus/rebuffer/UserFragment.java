package com.orpheus.rebuffer;

import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Toast;

/**
 * Created by David on 2/17/2018.
 */

public class UserFragment extends ListFragment implements OnItemClickListener{

    //*****----Inflater buat ngedesign apa aja yg ada dalam fragment-----*****//
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.user_fragment, container, false);
        return view;
    }

    //*****------ini buat content dari si fragment-----*****//
    @Override
    public void onActivityCreated (Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.sample,android.R.layout.simple_list_item_1);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    /* onItemClick dipake buat ganti ke page pilihan berikutnya
     * todo: Hapus Toast trus coba lempar ke fragment baru jadi gk banyak activity
     *  */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
        Toast.makeText(getActivity(), "Item: " + position, Toast.LENGTH_SHORT).show();
        Intent intent = new Intent( getActivity(),LoginActivity.class);
        startActivity(intent);
    }
}
