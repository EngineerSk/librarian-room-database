package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.ReadingList

@Dao
interface ReadingListDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReadingList(readingList: ReadingList)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateReadingList(readingList: ReadingList)

    @Query("SELECT * FROM reading_list")
    fun getReadingList():List<ReadingList>

    @Delete
    fun removeReadingList(readingList: ReadingList)
}