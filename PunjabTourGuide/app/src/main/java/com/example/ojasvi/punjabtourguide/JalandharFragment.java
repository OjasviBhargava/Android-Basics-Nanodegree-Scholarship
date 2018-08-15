package com.example.ojasvi.punjabtourguide;


import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class JalandharFragment extends android.support.v4.app.Fragment {

    GridView mGridView;
    private ArrayList<Locale> mArrayList = new ArrayList<>();

    public JalandharFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_jalandhar, container, false);
        mGridView = view.findViewById(R.id.gridview);

        if (mArrayList.size() == 0){
            loadGrid();
        }
        JalandharAdapter adapter = new JalandharAdapter(view.getContext() ,mArrayList);
        mGridView.setAdapter(adapter);
        return view;
    }

    public void loadGrid(){
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_1)));
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_2)));
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_3)));
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_4)));
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_2)));
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_1)));
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_3)));
        mArrayList.add(new Locale(getString(R.string.jalandhar_attraction_name_4)));

    }

}
