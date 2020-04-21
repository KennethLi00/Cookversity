package com.example.cookversity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


public class RecipesFragment extends Fragment {
    public static final String ARG_ITEM_ID = "item_id";
    private MainActivity main;
    private CuisineAdapter cAdapter;
    public static final String EXTRA_MESSAGE = "Hello";

    public static List<String> getCuisines() {
        List<String> CuisineList = new ArrayList<String>();
        CuisineList.add("European");
        CuisineList.add("Chinese");
        CuisineList.add("Korean");
        CuisineList.add("French");
        CuisineList.add("Japanese");
        CuisineList.add("Italian");
        CuisineList.add("Mediterranean");
        CuisineList.add("Vietnamese");
        CuisineList.add("Thai");
        CuisineList.add("Indian");
        return CuisineList;
    }

    public RecipesFragment() {
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
        View v = inflater.inflate(R.layout.fragment_recipes, container, false);
        RecyclerView rv = v.findViewById(R.id.rvList);
        rv.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        rv.setLayoutManager(mLayoutManager);
//        CuisineAdapter.RecyclerViewClickListener listener = new CuisineAdapter.RecyclerViewClickListener() {
//            @Override
//            public void onClick(View view, int position) {
//                System.out.println("get here");
//                FragmentTransaction t = getActivity().getSupportFragmentManager().beginTransaction();
//                t.replace(R.id.frameContainer, new RecipeListFragment());
//                t.addToBackStack(null);
//                t.commit();
//            }
//        };
        cAdapter = new CuisineAdapter(getActivity(), getCuisines());
        rv.setAdapter(cAdapter);
        return v;
    }

}
