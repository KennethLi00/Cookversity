package com.example.cookversity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

//https://www.androidauthority.com/lets-build-a-simple-text-editor-for-android-773774/
public class NotesFragment extends Fragment {
    private OnFragmentInteractionListener mListener;
    private List<NotesBuilder> notesList;
    private NotesAdapter adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton fabAdd;
    private TextView noteTitle;
    private TextView noteContent;

    public NotesFragment() {
        // Required empty public constructor
    }

    public static NotesFragment newInstance() {
        NotesFragment fragment = new NotesFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_notes, container, false);
        recyclerView = root.findViewById(R.id.rvNotesList);
        fabAdd = root.findViewById(R.id.fabAddNote);
        noteTitle = root.findViewById(R.id.tvNoteTitle);
        noteContent = root.findViewById(R.id.tvNoteContent);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), AddNote.class);
                startActivityForResult(intent, 1);
            }
        });

        notesList = new ArrayList<>();
        adapter = new NotesAdapter(notesList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        prepareNotes();

        return root;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
//        notesList.add(new NotesBuilder(data.getExtras().getString("title"), data.getExtras().getString("content")));
        prepareNotes();
        adapter.notifyDataSetChanged();
    }

    public interface OnFragmentInteractionListener {
        public void onArticleSelected(int position);
    }





    public void setmListener(OnFragmentInteractionListener listener) {
        this.mListener = listener;
    }

    private void prepareNotes() {
        File directory = getActivity().getFilesDir();
        File[] files = directory.listFiles();
        String theFile;

        if (notesList == null) {
            SkipPrepare();
        } else {
            notesList.clear();
            for(File f : files) {
                theFile = "Note " + f.getName() + ".txt";
                NotesBuilder note = new NotesBuilder(theFile, Open(f.getName()));
                notesList.add(note);
            }
//            for (int f = 1; f && notesList.size() == files.length; f++) {
//                theFile = "Note" + f + ".txt";
//                NotesBuilder note = new NotesBuilder(theFile, Open(theFile));
//                notesList.add(note);
//            }
        }
    }

    public void SkipPrepare() {
        System.out.println("skipped");
    }

    public String Open(String fileName) {
        String content = "";
        try {
            InputStream in = getActivity().openFileInput(fileName);
            if ( in != null) {
                InputStreamReader tmp = new InputStreamReader( in );
                BufferedReader reader = new BufferedReader(tmp);
                String str;
                StringBuilder buf = new StringBuilder();
                while ((str = reader.readLine()) != null) {
                    buf.append(str + "\n");
                } in .close();

                content = buf.toString();
            }
        } catch (java.io.FileNotFoundException e) {} catch (Throwable t) {
            Toast.makeText(getContext(), "Exception: " + t.toString(), Toast.LENGTH_LONG).show();
        }

        return content;
    }
}
