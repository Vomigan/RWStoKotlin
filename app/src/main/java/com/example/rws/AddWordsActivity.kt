package com.example.rws

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.rws.R
import android.widget.EditText
import com.example.rws.database.Words
import com.example.rws.database.WordsDatabase

class AddWordsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_words)
        val word = findViewById<EditText>(R.id.editTextTextPersonName)
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener { addNewWord(word.text.toString()) }
    }

    private fun addNewWord(word: String) {
        val db = WordsDatabase.getDbInstance(this.applicationContext)
        val words = Words()
        words.word = word
        db.wordsDao().insertWords(words)
        finish()
    }
}