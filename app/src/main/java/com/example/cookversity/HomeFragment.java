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
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ViewFlipper;

import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {
//    private OnFragmentInteractionListener mListener;
    ViewFlipper viewFlipper;
    Context mContext;

    public HomeFragment() {
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
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //connect view flipper with view flipper in layout
        viewFlipper = (ViewFlipper) root.findViewById(R.id.vfFlipper);

        //getActivity provides context for fragments (https://stackoverflow.com/questions/8215308/using-context-in-a-fragment)
        mContext = getActivity();

        //Makes textviews look like they're sliding
        //Source: https://abhiandroid.com/ui/viewflipper
        Animation in = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_in_left);
        Animation out = AnimationUtils.loadAnimation(mContext, android.R.anim.slide_out_right);
        viewFlipper.setInAnimation(in);
        viewFlipper.setOutAnimation(out);

        //Source: https://developer.android.com/reference/android/widget/ViewFlipper
        //Used website to understand methods for ViewFlipper and how to code methods.
        viewFlipper.setFlipInterval(3000);
        viewFlipper.setAutoStart(true);
        return root;
    }

}
