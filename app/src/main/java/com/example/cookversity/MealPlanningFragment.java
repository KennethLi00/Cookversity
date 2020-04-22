package com.example.cookversity;

import android.content.Context;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class MealPlanningFragment extends Fragment {
    private WebView website;

    public MealPlanningFragment() {
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
        View root = inflater.inflate(R.layout.fragment_meal_planning, container, false);
        website = root.findViewById(R.id.wvMealPlanning);
        website.loadUrl("https://www.healthlinkbc.ca/healthy-eating/meal-planning");
        return root;
    }
}
