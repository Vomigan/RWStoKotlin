package com.example.rws;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.rws.database.Words;
import com.example.rws.database.WordsDatabase;
import com.example.rws.database.WordsListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private WordsListAdapter wordsListAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = findViewById(R.id.floatingActionButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddWordsActivity.class);
                startActivity(intent);
            }
        });
        initRecyclerView();
        loadWordsList();
    }
    private void initRecyclerView(){
        RecyclerView recyclerView =findViewById(R.id.RV);
        recyclerView.setLayoutManager((new LinearLayoutManager(this)));
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        wordsListAdapter = new WordsListAdapter(this);
        recyclerView.setAdapter(wordsListAdapter);
    }
    private void loadWordsList(){
        WordsDatabase db = WordsDatabase.getDbInstance(this.getApplicationContext());
        List<Words> wordsList = db.wordsDao().getAllWords();
        wordsListAdapter.setUserList(wordsList);
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if(requestCode == 100){
            loadWordsList();
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}