package com.example.ojasvi.surasvi;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ojasvi on 13-07-2018.
 */

public class AlbumsAdapter extends ArrayAdapter<Songs> {

    private ArrayList<Songs> arrayList;

    public AlbumsAdapter(@NonNull Context context, ArrayList<Songs> arrayList) {
        super(context, 0,arrayList);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = convertView;

        if (view == null) {
            view = LayoutInflater.from(getContext()).inflate(R.layout.albums_card, parent, false);
        }
        Songs song = getItem(position);
        ImageView image = view.findViewById(R.id.album_thumbnail);
        Picasso.get().load(song.getImage()).into(image);
        TextView category_name = view.findViewById(R.id.title);

        category_name.setText(song.getSongName());
        return view;
    }
}
