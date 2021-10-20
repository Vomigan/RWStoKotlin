package com.example.rws;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.rws.database.Words;
import com.example.rws.database.WordsDatabase;

public class AddWordsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_words);
        EditText word = findViewById(R.id.editTextTextPersonName);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addNewWord(word.getText().toString());
            }
        });
    }
    private void addNewWord(String word){
        WordsDatabase db = WordsDatabase.getDbInstance(this.getApplicationContext());
        Words words = new Words();
        words.word = word;

        db.wordsDao().insertWords(words);
        finish();
    }
}