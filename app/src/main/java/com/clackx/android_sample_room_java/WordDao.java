package com.clackx.android_sample_room_java;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    void insert(Word word);

    @Query("SELECT * FROM words_table ORDER BY word ASC")
    LiveData<List<Word>> getAllWords();

    @Query("DELETE FROM words_table")
    void deleteAllWords();
}
