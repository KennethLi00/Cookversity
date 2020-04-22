package com.example.cookversity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NutritionAdapter extends  RecyclerView.Adapter<NutritionAdapter.ViewHolder> {
    private FragmentActivity main;
    private List<Nutrition> mList;
    private OnWebListener listener;

    @NonNull
    @Override
    public NutritionAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.nutrition_list_row, parent, false);
        return new ViewHolder(v, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull NutritionAdapter.ViewHolder holder, int position) {
        Nutrition n = mList.get(position);
        holder.webTitle.setText(n.getTitle());
        holder.url.setText(n.getUrl());
        holder.logo.setImageResource(n.getLogo());
    }

    public NutritionAdapter(List<Nutrition> list, OnWebListener listener) {
        this.mList = list;
        this.listener = listener;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView webTitle;
        public TextView url;
        public ImageView logo;
        OnWebListener listener;

        public ViewHolder(View v, OnWebListener listener) {
            super(v);
            webTitle = v.findViewById(R.id.tvWebTitle);
            url = v.findViewById(R.id.tvUrl);
            logo = v.findViewById(R.id.ivLogo);
            this.listener = listener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            listener.onWebListener(getAdapterPosition());
        }
    }
    public interface OnWebListener {
        void onWebListener(int position);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }
}
