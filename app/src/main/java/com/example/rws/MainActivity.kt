package com.example.rws

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.rws.MainActivity
import com.example.rws.database.WordsDatabase
import com.example.rws.database.WordsListAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {
    private var wordsListAdapter: WordsListAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        loadWordsList()
        val button = findViewById<FloatingActionButton>(R.id.floatingActionButton)
        button.setOnClickListener {
            val intent = Intent(this, AddWordsActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.RV)
        recyclerView.layoutManager = LinearLayoutManager(this)
        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        recyclerView.addItemDecoration(dividerItemDecoration)
        db = WordsDatabase.getDbInstance(applicationContext)
        val wordsList = db!!.wordsDao().allWords
        wordsListAdapter = WordsListAdapter(wordsList)
        recyclerView.adapter = wordsListAdapter
    }

    private fun loadWordsList() {
        val db = WordsDatabase.getDbInstance(this.applicationContext)
        val wordsList = db.wordsDao().allWords
        wordsListAdapter!!.setUserList(wordsList)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == 100) {
            loadWordsList()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }

    override fun onResume() {
        super.onResume()
        loadWordsList()
    }

    companion object {
        var db: WordsDatabase? = null
    }
}