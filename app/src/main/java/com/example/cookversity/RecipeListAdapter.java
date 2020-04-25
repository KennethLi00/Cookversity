package com.example.cookversity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cookversity.Entities.Recipe;
import com.example.cookversity.Entities.RecipeShort;

import java.util.List;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder> {

    private FragmentActivity frag;
    private List<RecipeShort> recipeList;
    private View.OnClickListener onClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View v) {
            RecipeShort recipe = (RecipeShort) v.getTag();
            Bundle arguments = new Bundle();
            arguments.putInt(RecipeDetailFragment.RECIPE_ID, recipe.getId());
            System.out.println(recipe.getTitle());
            RecipeDetailFragment fragment = new RecipeDetailFragment();
            fragment.setArguments(arguments);
            FragmentTransaction t = frag.getSupportFragmentManager().beginTransaction();
            t.addToBackStack(null);
            t.replace(R.id.frameContainer, fragment).commit();
        }
    };

    public RecipeListAdapter(FragmentActivity parent, List<RecipeShort> r) {
        frag = parent;
        recipeList = r;
    }

    public static class RecipeListViewHolder extends RecyclerView.ViewHolder {
        public TextView RecipeName;

        public RecipeListViewHolder(View v) {
            super(v);
            RecipeName = v.findViewById(R.id.tvRecipeListName);
        }

    }

    @Override
    public RecipeListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_row, parent, false);
        return new RecipeListViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecipeListViewHolder holder, int position) {
        RecipeShort r = recipeList.get(position);
        holder.RecipeName.setText(r.getTitle());
        holder.itemView.setTag(r);
        holder.itemView.setOnClickListener(onClickListener);
    }

    public void setRecipes(List<RecipeShort> recipes) {
        recipeList.clear();
        recipeList.addAll(recipes);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }
}
