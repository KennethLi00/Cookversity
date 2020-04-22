package com.example.cookversity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class NutritionInfoFragment extends Fragment implements NutritionAdapter.OnWebListener {
    private RecyclerView recyclerView;
    private NutritionAdapter mAdapter;
    private List<Nutrition> mList = Nutrition.getNutritionWebsList();

    public NutritionInfoFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_nutrition_info, container, false);
        recyclerView = root.findViewById(R.id.rvNutritionInfoList);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(mLayoutManager);

//        mAdapter = new NutritionAdapter(getActivity(), mList);
        mAdapter = new NutritionAdapter(mList, this);
        recyclerView.setAdapter(mAdapter);

        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }

    @Override
    public void onWebListener(int position) {
        mList.get(position);
        Intent intent = new Intent(getContext(), NutritionWeb.class);
        intent.putExtra("url", mList.get(position).getUrl());
        intent.putExtra("title", mList.get(position).getTitle());
        startActivity(intent);
    }
}
