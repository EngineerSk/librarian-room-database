package com.raywenderlich.android.librarian.repository

import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.BooksByGenre
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks

interface LibrarianRepository {

    fun addBook(book: Book)
    fun getBooks(): List<BookAndGenre>
    fun getBookById(bookId: String): Book
    fun getGenres(): List<Genre>
    fun getGenreById(genreId: String): Genre
    fun removeBook(book: Book)
    fun addGenres(genres: List<Genre>)
    fun addReview(review: Review)
    fun getReviews(): List<BookReview>
    fun getReviewById(reviewId: String): BookReview
    fun removeReview(review: Review)
    fun updateReview(review: Review)
    fun addReadingList(readingList: ReadingList)
    fun getReadingLists(): List<ReadingListsWithBooks>
    fun removeReadingList(readingList: ReadingList)
    fun getBooksByGenre(genreId: String): List<BookAndGenre>
    fun getBooksByGenres(): List<BooksByGenre>
    fun getBookReviewByRating(rating: Int): List<BookAndGenre>
}