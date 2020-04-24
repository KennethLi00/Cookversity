package com.example.cookversity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.io.File;

public class CleanAllFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_cleanall, container, false);

        Button button = root.findViewById(R.id.cleanbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File directory = getActivity().getFilesDir();
                File[] files = directory.listFiles();
                for(File f : files) {
                   f.delete();
                }
                Toast.makeText(root.getContext(), "Cleaned!", Toast.LENGTH_SHORT).show();
            }
        });

        return root;
    }
}
