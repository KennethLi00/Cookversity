package com.example.cookversity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CuisineAdapter extends RecyclerView.Adapter<CuisineAdapter.CuisineViewHolder> {

    private FragmentActivity main;
    private RecyclerViewClickListener rListener;
    private List<String> CuisineList;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            System.out.println("herererer");
            String s = (String) v.getTag();
            Bundle arguments = new Bundle();
            arguments.putString(RecipesFragment.ARG_ITEM_ID, s);
            RecipesFragment fragment = new RecipesFragment();
            fragment.setArguments(arguments);
            main.getSupportFragmentManager().beginTransaction().replace(R.id.frameContainer, new RecipeListFragment()).commit();
        }
    };

    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }

    public CuisineAdapter(FragmentActivity parent, List<String> list) {
        main = parent;
        CuisineList = list;
    }

    public static class CuisineViewHolder extends RecyclerView.ViewHolder {
        public TextView CuisineName;

        public CuisineViewHolder(View v) {
            super(v);
            CuisineName = v.findViewById(R.id.tvCuisineListName);
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
        holder.itemView.setOnClickListener(mOnClickListener);
    }

    @Override
    public int getItemCount() {
        return CuisineList.size();
    }
}
