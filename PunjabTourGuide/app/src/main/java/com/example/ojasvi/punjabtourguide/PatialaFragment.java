package com.example.ojasvi.punjabtourguide;


import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PatialaFragment extends android.support.v4.app.Fragment {
    RecyclerView  recyclerView;

    public PatialaFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_patiala, container, false);
        recyclerView = view.findViewById(R.id.pat_rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        populateRV();
        return view;
    }

    private void populateRV() {
        ArrayList<Locale> mArrayList = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            mArrayList.add(new Locale(getString(R.string.place) + i));
        }
        PatialaAdapter adapter = new PatialaAdapter(mArrayList);
        recyclerView.setAdapter(adapter);
    }
}