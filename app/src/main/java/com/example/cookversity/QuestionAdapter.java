package com.example.cookversity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class QuestionAdapter extends  RecyclerView.Adapter<QuestionAdapter.ViewHolder> {

    private Context context;
    private List<Quiz> articles;
    public QuestionAdapter(Context context, List<Quiz> articles) {
        this.context = context;
        this.articles = articles;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_question, parent,false);
        return  new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        Quiz article = articles.get(position);
        holder.mTvName.setText(article.getTitle());


        holder.tv_collect.setText(article.getOK());
        if (article.getOK().equals(article.getAnswer())){
            holder.mtvType.setText("correct");
        }else{
            holder.mtvType.setText("Incorrect");
        }


    }

    @Override
    public int getItemCount() {
        return articles.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView mTvName;
        TextView tv_collect;
        TextView mtvType;
        public ViewHolder(View itemView) {
            super(itemView);
            mTvName = itemView.findViewById(R.id.tv_title);
            tv_collect = itemView.findViewById(R.id.tv_collect);
            mtvType = itemView.findViewById(R.id.tv_type);
        }
    }
}
