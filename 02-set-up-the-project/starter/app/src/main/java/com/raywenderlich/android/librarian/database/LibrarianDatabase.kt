package com.raywenderlich.android.librarian.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.raywenderlich.android.librarian.database.dao.BookDao
import com.raywenderlich.android.librarian.database.dao.GenreDao
import com.raywenderlich.android.librarian.database.dao.ReadingListDao
import com.raywenderlich.android.librarian.database.dao.ReviewDao
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review

const val DATABASE_VERSION = 1

@Database(
    entities = [Book::class, Genre::class, ReadingList::class, Review::class],
    version = DATABASE_VERSION
)
abstract class LibrarianDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME = "Librarian"

        fun buildDatabase(context: Context): LibrarianDatabase {
            return Room.databaseBuilder(
                context,
                LibrarianDatabase::class.java,
                DATABASE_NAME
            )
                .allowMainThreadQueries()
                .build()
        }
    }

    abstract fun bookDao(): BookDao
    abstract fun genreDao(): GenreDao
    abstract fun reviewDao(): ReviewDao
    abstract fun readingListDao(): ReadingListDao
}