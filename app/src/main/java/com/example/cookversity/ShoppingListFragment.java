package com.example.cookversity;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

//https://guides.codepath.com/android/Basic-Todo-App-Tutorial
//Used tutorial to build shopping list
//https://www.youtube.com/watch?v=1bBwJDCww3g
//Used video to build snackbar

public class ShoppingListFragment extends Fragment {
    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView mList;
    private Button addButton;
    private EditText input;
    private CoordinatorLayout layout;
    private OnFragmentInteractionListener mListener;

    public ShoppingListFragment() {
        // Required empty public constructor
    }
//
//    public static ShoppingListFragment newInstance(String param1, String param2) {
//        ShoppingListFragment fragment = new ShoppingListFragment();
//        Bundle args = new Bundle();
//
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        readData();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_shopping_list, container, false);
        readData();
        mList = root.findViewById(R.id.lvShoppingList);
        addButton = root.findViewById(R.id.btAddShoppingItem);
        input = root.findViewById(R.id.etNewShoppingItem);
        layout = root.findViewById(R.id.clShoppingList);

        items = new ArrayList<>();
        itemsAdapter = new ArrayAdapter<String>(getContext(), android.R.layout.simple_list_item_1, items);
        mList.setAdapter(itemsAdapter);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = input.getText().toString();
                itemsAdapter.add(text);
                input.setText("");
                writeData();
            }
        });

        OnLongPress();

        return root;
    }

    private void OnLongPress() {
        mList.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                Snackbar snackbar = Snackbar.make(layout, "Delete/bought item?", Snackbar.LENGTH_LONG)
                        .setAction("YES", new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                items.remove(position);
                                itemsAdapter.notifyDataSetChanged();
                                writeData();
                            }
                        });
                snackbar.show();
                return true;
            }
        });
    }

    private void readData() {
        File directory = getContext().getFilesDir();
        File todo = new File(directory, "todo.txt");
        try {
            items = new ArrayList<String>(FileUtils.readLines(todo));
        } catch (IOException ex) {
            items = new ArrayList<>();
        }
    }

    private void writeData() {
        File directory = getContext().getFilesDir();
        File todo = new File(directory, "todo.txt");
        try {
            FileUtils.writeLines(todo, items);
        } catch (IOException ex) {
            System.out.println("failed");
            ex.printStackTrace();
        }
    }

//    public  ShoppingListFragment newInstance() {
//        ShoppingListFragment fragment = new ShoppingListFragment();
//        Bundle args = new Bundle();
//        fragment.setArguments(args);
//        readData();
//        return fragment;
//    }
//    @Override
//    public void onAttach(Context context) {
//        super.onAttach(context);
//        if (context instanceof OnFragmentInteractionListener) {
//            mListener = (OnFragmentInteractionListener) context;
//            readData();
//        } else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
//    }
//
//    @Override
//    public void onDetach() {
//        super.onDetach();
//    }

//    @Override
//    public void onSaveInstanceState(@NonNull Bundle outState) {
//        super.onSaveInstanceState(outState);
//        readData();
//    }
//
//    @Override
//    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
//        super.onActivityCreated(savedInstanceState);
//
//        if(savedInstanceState != null) {
//            readData();
//        }
//    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }
}
