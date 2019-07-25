package com.clackx.android_sample_room_java;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Word.class}, version = 1)
abstract class WordRoomDatabase extends RoomDatabase {
    abstract WordDao wordDao();

    private static volatile WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(Context context) {
        if (INSTANCE == null) {
            synchronized (WordRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "words_table")
                            .build();
                }
            }
        }
        return INSTANCE;
    }

}
