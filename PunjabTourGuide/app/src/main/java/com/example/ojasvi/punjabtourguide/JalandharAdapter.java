package com.example.ojasvi.punjabtourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ojasvi on 15-08-2018.
 */

public class JalandharAdapter extends ArrayAdapter<Locale> {

    public JalandharAdapter(@NonNull Context context, ArrayList<Locale> list) {
        super(context, 0,list);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;
        if (view == null){
            view = LayoutInflater.from(getContext()).inflate(R.layout.custom_row,parent,false);
        }

        Locale locale = getItem(position);
        assert locale != null;

        TextView category_name = view.findViewById(R.id.location_title);
        category_name.setText(locale.getmLocationName());
        return view;
    }
}
