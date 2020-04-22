package com.example.cookversity;

import android.content.Context;
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


public class NutritionFragment extends Fragment {
    private View view;
    private RecyclerView recyclerView;
    private FoodAdapter adapter;


//    private OnFragmentInteractionListener mListener;

    public NutritionFragment() {
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
        view = inflater.inflate(R.layout.fragment_nutrition, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.recyclerView);
        List<Food> list = new ArrayList<>();
        list.add(new Food("Egg(each) ","1kcal",R.drawable.egg));
        list.add(new Food("Flour(50g)","175kcal",R.drawable.flower));
        list.add(new Food("Milk(240ml)","146kcal",R.drawable.milk));
        list.add(new Food("Grain(100g)","375kcal",R.drawable.grain));
        list.add(new Food("Sugar(1 tablespoon)","60kcal",R.drawable.sugar));
        list.add(new Food("Pork(100g)","165kcal",R.drawable.pork));
        list.add(new Food("Beef(100g)","173kcal",R.drawable.beef));
        list.add(new Food("Chicken(100g)","137 kcal",R.drawable.chicken));
        list.add(new Food("pasta(70g)","252kcal",R.drawable.paste));
        list.add(new Food("Cheese(33g)"," 130kcal",R.drawable.cheese));
        adapter = new FoodAdapter(getActivity(),  list);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);
    }
}
