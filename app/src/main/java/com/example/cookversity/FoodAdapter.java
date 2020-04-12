package com.example.cookversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class FoodAdapter extends  RecyclerView.Adapter<FoodAdapter.ViewHolder> {

    private Context context;
    private List<Food> articles;
    public FoodAdapter(Context context, List<Food> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_food, parent,false);
        return  new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Food food = articles.get(position);
        holder.mTvName.setText(food.getName());
        holder.tv_cal.setText(food.getCal());

        holder.iv_image.setImageResource(food.getImage());



    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTvName;
        ImageView iv_image;
        TextView tv_cal;
        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_title);
            iv_image = itemView.findViewById(R.id.iv_image);
            tv_cal = itemView.findViewById(R.id.tv_cal);
        }
    }
}
