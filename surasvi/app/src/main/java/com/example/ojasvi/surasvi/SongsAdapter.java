package com.example.ojasvi.surasvi;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by Ojasvi on 12-07-2018.
 */

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private ArrayList<Songs> arrayList;

    public SongsAdapter(ArrayList<Songs> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.song_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Songs song = arrayList.get(position);
        holder.txtSongName.setText(song.getSongName());
        holder.textSongArtist.setText(song.getDesc());
        Picasso.get().load(song.getImage()).into(holder.songThumbnail);

        holder.txtSongName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                v.getContext().startActivity(new Intent(v.getContext(), PlayerActivity.class));
            }
        });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Context mContext;
        TextView txtSongName;
        TextView textSongArtist;
        ImageView songThumbnail;
        ImageButton songOverflowButton;

        public ViewHolder(View itemView) {
            super(itemView);
            mContext = itemView.getContext();
            txtSongName = itemView.findViewById(R.id.trackTitle);
            textSongArtist = itemView.findViewById(R.id.songDesc);
            songThumbnail = itemView.findViewById(R.id.songImage);
            songOverflowButton = itemView.findViewById(R.id.song_overflow_button);
        }
    }
}