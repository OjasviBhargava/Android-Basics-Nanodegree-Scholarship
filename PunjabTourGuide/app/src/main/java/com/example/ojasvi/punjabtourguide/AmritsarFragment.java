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
public class AmritsarFragment extends android.support.v4.app.Fragment {
    RecyclerView mRecyclerView;

    public AmritsarFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_amritsar, container, false);
        mRecyclerView = view.findViewById(R.id.amritsar_rv);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);

        loadData();
        return view;
    }

    private void loadData() {
        ArrayList<Locale> mArrayList = new ArrayList<>();
        for(int i = 0; i< 10; i++){
            mArrayList.add(new Locale(getString(R.string.place) + i));
        }
        AmritsarAdapter adapter = new AmritsarAdapter(mArrayList);
        mRecyclerView.setAdapter(adapter);

    }

}
