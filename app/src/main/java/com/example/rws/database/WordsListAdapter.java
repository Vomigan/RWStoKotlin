package com.example.rws.database;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rws.MainActivity;
import com.example.rws.R;

import java.util.List;

public class WordsListAdapter extends RecyclerView.Adapter<WordsListAdapter.MyViewHolder> {
    private Context context;
    private List<Words> wordsList;
    public  WordsListAdapter(MainActivity mainActivity){
        this.context = context;
    }
    public void setUserList(List<Words> wordsList){
        this.wordsList = wordsList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public WordsListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WordsListAdapter.MyViewHolder holder, int position) {
        holder.textViewWord.setText(this.wordsList.get(position).word);

    }

    @Override
    public int getItemCount() {
        return this.wordsList.size();
    }
    public  class MyViewHolder extends RecyclerView.ViewHolder{
        TextView textViewWord;
        public MyViewHolder(View view){
            super(view);
            textViewWord = view.findViewById(R.id.textViewWord);
        }
    }
}
