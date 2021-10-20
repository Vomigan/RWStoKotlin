package com.example.rws.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Words.class}, version = 1, exportSchema = false)
public abstract class WordsDatabase extends RoomDatabase {
    public abstract WordsDao wordsDao();
    private static WordsDatabase INSTANCE;

    public static WordsDatabase getDbInstance(final Context context){
        if (INSTANCE == null){
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    WordsDatabase.class, "WordsDb")
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}