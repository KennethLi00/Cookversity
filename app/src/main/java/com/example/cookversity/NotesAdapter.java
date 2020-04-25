package com.example.cookversity;

import android.os.AsyncTask;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.ViewHolder> {
    private List<NotesBuilder> mList;

    @NonNull
    @Override
    public NotesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.notes_list_row, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull NotesAdapter.ViewHolder holder, int position) {
        NotesBuilder note = mList.get(position);
        holder.title.setText(note.getTitle());
        holder.noteContent.setText(note.getContent());
    }

    @Override
    public int getItemCount() {
        if (mList == null) {
            return 0;
        } else {
            return mList.size();
        }

    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView title;
        public TextView noteContent;

        public ViewHolder(View v) {
            super(v);
            title = v.findViewById(R.id.tvNoteTitle);
            noteContent = v.findViewById(R.id.tvNoteContent);
        }
    }

    public NotesAdapter (List<NotesBuilder> list) {
        this.mList = list;
    }

    public void setNotes(List<NotesBuilder> notes) {
        mList.addAll(notes);
        notifyDataSetChanged();
    }
}
