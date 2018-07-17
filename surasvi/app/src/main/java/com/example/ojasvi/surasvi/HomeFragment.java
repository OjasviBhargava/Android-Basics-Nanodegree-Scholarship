package com.example.ojasvi.surasvi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment {

    private SongsAdapter songsAdapter;
    private RecyclerView mRecyclerView;
    private ArrayList<Songs> arrayList;

    String names[] = new String[30];
    String artistNames[] = new String[30];
    int covers[] = new int[30];

    public HomeFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        mRecyclerView = v.findViewById(R.id.songList);
        songsAdapter = new SongsAdapter(arrayList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setItemViewCacheSize(20);
        mRecyclerView.setDrawingCacheEnabled(true);
        mRecyclerView.setDrawingCacheQuality(View.DRAWING_CACHE_QUALITY_HIGH);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        for (int i=0; i <= 29; i++){
            names[i] = "Random Song Title";
        }
        for (int i=0; i<29; i++){
            artistNames[i] = "Random Song Description";
        }
        for (int i=0; i<29; i++){
            covers[i] = R.drawable.dua_lipa;
        }
        loadData();
    }

    private void loadData() {
        arrayList = new ArrayList<>();
        for(int i=0; i<29; i++){
            arrayList.add(new Songs(names[i],artistNames[i],covers[i]));
        }
        songsAdapter = new SongsAdapter(arrayList);
        mRecyclerView.setAdapter(songsAdapter);
    }
}