package com.example.cookversity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.material.tabs.TabLayout;

import java.io.Serializable;
import java.util.List;

//public class CookbookFragment extends Fragment implements NotesFragment.OnFragmentInteractionListener, ShoppingListFragment.OnFragmentInteractionListener, SavedRecipesFragment.OnFragmentInteractionListener{
public class CookbookFragment extends Fragment {
private TabLayout tabLayout;
    private ViewPager viewPager;
    private MyPagerAdapter adapter;
//    private ShoppingListFragment mMyFragment;
//    private List<String> data;

//    https://developer.android.com/training/basics/fragments/communicating.html
//    https://stackoverflow.com/questions/41413150/fragment-tabs-inside-fragment
    public CookbookFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_cookbook, container, false);
        tabLayout = root.findViewById(R.id.tlTabs);
        viewPager = root.findViewById(R.id.vpPager);
        setUpViewPager(viewPager);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }

    private void setUpViewPager(ViewPager viewPager) {
        adapter = new MyPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new NotesFragment(), "Notes");
        adapter.addFragment(new ShoppingListFragment(), "Grocery List");
        adapter.addFragment(new SavedRecipesFragment(), "My Recipes");
        viewPager.setAdapter(adapter);
    }
//
//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
////        outState.putSerializable("list", (Serializable) data);
////       getActivity().getSupportFragmentManager().putFragment(outState, "ShoppingListFragment", mMyFragment);
//    }

}
