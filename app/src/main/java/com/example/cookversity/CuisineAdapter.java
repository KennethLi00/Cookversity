package com.example.cookversity;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {

    private FragmentActivity main;
    private Context context;
    private List<String> CuisineList;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String s = (String) v.getTag();
            Bundle arguments = new Bundle();
            arguments.putString(RecipeListFragment.ARG_ITEM_ID, s);
            RecipeListFragment fragment = new RecipeListFragment();
            fragment.setArguments(arguments);
            FragmentTransaction t = main.getSupportFragmentManager().beginTransaction();
            t.addToBackStack(null);
            t.replace(R.id.frameContainer, fragment).commit();
        }
    };


    public CuisineAdapter(FragmentActivity parent, List<String> list, Context context) {
        main = parent;
        CuisineList = list;
        this.context = context;
    }

    public static class CuisineViewHolder extends RecyclerView.ViewHolder {
        public TextView CuisineName;
        public ImageView iv;
        public CuisineViewHolder(View v) {
            super(v);
            CuisineName = v.findViewById(R.id.tvCuisineListName);
            iv = v.findViewById(R.id.ivFlag);
        }

    }

    @Override
    public CuisineAdapter.CuisineViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cuisine_row, parent, false);
        return new CuisineViewHolder(v);
    }

    @Override
    public void onBindViewHolder(CuisineViewHolder holder, int position) {
        String c = CuisineList.get(position);
        holder.CuisineName.setText(c);
        switch (c) {
            case "European":
                holder.iv.setImageResource(R.drawable.european);
                break;
            case "Chinese":
                holder.iv.setImageResource(R.drawable.china);
                break;
            case "Korean":
                holder.iv.setImageResource(R.drawable.korean);
                break;
            case "French":
                holder.iv.setImageResource(R.drawable.french);
                break;
            case "Japanese":
                holder.iv.setImageResource(R.drawable.japan);
                break;
            case "Italian":
                holder.iv.setImageResource(R.drawable.italian);
                break;
            case "Mediterranean":
                holder.iv.setImageResource(R.drawable.mediterranean);
                break;
            case "Vietnamese":
                holder.iv.setImageResource(R.drawable.vietnamese);
                break;
            case "Thai":
                holder.iv.setImageResource(R.drawable.thai);
                break;
            case "Indian":
                holder.iv.setImageResource(R.drawable.indian);
                break;
        }
        holder.itemView.setTag(c);
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return CuisineList.size();
    }
}
