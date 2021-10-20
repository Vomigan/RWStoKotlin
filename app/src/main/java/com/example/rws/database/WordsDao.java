package com.example.rws.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordsDao {
    @Query("SELECT * FROM Words")
    List<Words> getAllWords();
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertWords(Words words);
}
