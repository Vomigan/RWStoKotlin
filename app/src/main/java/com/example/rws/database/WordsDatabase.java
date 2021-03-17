package com.example.rws.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Words.class}, version = 1)
public abstract class WordsDatabase extends RoomDatabase {
    public abstract WordsDao wordsDao();
    private static WordsDatabase INSTANCE;
    public static WordsDatabase getDbInstance(Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(), WordsDatabase.class, "Words")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}