package com.example.cookversity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;


public class QuestionResultActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    List<Quiz> list;
    private QuestionAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        initData();
    }



    protected void initData() {
        Toolbar toolbar =  findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("RecipeShort");
        recyclerView = findViewById(R.id.recyclerView);
        list = (List<Quiz>) getIntent().getSerializableExtra("data");
        adapter = new QuestionAdapter(this,  list);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }




}
