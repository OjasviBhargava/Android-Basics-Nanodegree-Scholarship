package com.example.ojasvi.surasvi;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AlbumFragment extends Fragment {

    private final ArrayList<Songs> list = new ArrayList<>();

    public AlbumFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_album, container, false);
        if (list.size() == 0) {
            populate();
        }

        GridView gridView = v.findViewById(R.id.gridView);
        AlbumsAdapter adapter = new AlbumsAdapter(getActivity(), list);
        gridView.setAdapter(adapter);

        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        populate();
    }

    private void populate() {
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
        list.add(new Songs("Dua Lipa", R.drawable.dua_lipa_album));
    }
}