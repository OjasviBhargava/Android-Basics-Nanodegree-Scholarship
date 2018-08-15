package com.example.ojasvi.punjabtourguide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Ojasvi on 15-08-2018.
 */

public class ChandigarhAdapter extends RecyclerView.Adapter<ChandigarhAdapter.ViewHolder>{

    private ArrayList<Locale> arrayList;

    public ChandigarhAdapter(ArrayList<Locale> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ChandigarhAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.attraction_row,parent,false);
        return new ChandigarhAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Locale locale = arrayList.get(position);
        holder.textView.setText(locale.getmLocationName());
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        Context context;
        TextView textView;

        ViewHolder(View itemView){
            super(itemView);
            textView = itemView.findViewById(R.id.placeName);
            context = itemView.getContext();
        }
    }
}
