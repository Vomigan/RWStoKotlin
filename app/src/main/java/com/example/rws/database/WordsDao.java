package com.example.rws.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordsDao {
    @Query("SELECT * FROM words")
    List<Words> getAllWords();
    @Insert
    void insertWords(Words... words);


}
