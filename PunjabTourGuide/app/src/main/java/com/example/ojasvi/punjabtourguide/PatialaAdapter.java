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

public class PatialaAdapter extends RecyclerView.Adapter<PatialaAdapter.ViewHolder>{

    private ArrayList<Locale> arrayList;

    public PatialaAdapter(ArrayList<Locale> arrayList) {
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public PatialaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.patiala_row,parent,false);
        return new PatialaAdapter.ViewHolder(view);
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
            textView = itemView.findViewById(R.id.dest_title);
            context = itemView.getContext();
        }
    }
}
