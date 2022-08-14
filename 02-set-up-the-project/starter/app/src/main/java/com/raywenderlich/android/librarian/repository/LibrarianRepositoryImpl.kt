package com.raywenderlich.android.librarian.repository

import com.raywenderlich.android.librarian.database.dao.BookDao
import com.raywenderlich.android.librarian.database.dao.GenreDao
import com.raywenderlich.android.librarian.database.dao.ReadingListDao
import com.raywenderlich.android.librarian.database.dao.ReviewDao
import com.raywenderlich.android.librarian.model.Book
import com.raywenderlich.android.librarian.model.Genre
import com.raywenderlich.android.librarian.model.ReadingList
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookAndGenre
import com.raywenderlich.android.librarian.model.relations.BookReview
import com.raywenderlich.android.librarian.model.relations.BooksByGenre
import com.raywenderlich.android.librarian.model.relations.ReadingListsWithBooks

class LibrarianRepositoryImpl(
    private val bookDao: BookDao,
    private val genreDao: GenreDao,
    private val readingListDao: ReadingListDao,
    private val reviewDao: ReviewDao
) : LibrarianRepository {
    override fun addBook(book: Book) {
        bookDao.addBook(book)
    }

    override fun getBooks(): List<BookAndGenre> {
        return bookDao.getBooks()
    }

    override fun getBookById(bookId: String): Book {
        return bookDao.getBookById(bookId)
    }

    override fun getGenres(): List<Genre> {
        return genreDao.getGenres()
    }

    override fun getGenreById(genreId: String): Genre {
        return genreDao.getGenreById(genreId)
    }

    override fun removeBook(book: Book) {
        bookDao.removeBook(book)
    }

    override fun addGenres(genres: List<Genre>) {
        genreDao.addGenres(genres)
    }

    override fun addReview(review: Review) {
        reviewDao.addReview(review)
    }

    override fun getReviews(): List<BookReview> = reviewDao.getReviews()

    override fun getReviewById(reviewId: String): BookReview = reviewDao.getReviewById(reviewId)

    override fun removeReview(review: Review) {
        reviewDao.deleteReview(review)
    }

    override fun updateReview(review: Review) {
        reviewDao.updateReview(review)
    }

    override fun addReadingList(readingList: ReadingList) {
        readingListDao.addReadingList(readingList)
    }

    override fun getReadingLists(): List<ReadingListsWithBooks> {
        return readingListDao.getReadingList()
            .map { ReadingListsWithBooks(it.id, it.name, emptyList()) }
    }

    override fun removeReadingList(readingList: ReadingList) {
        readingListDao.removeReadingList(readingList)
    }

    override fun getBooksByGenre(genreId: String): List<BookAndGenre> {
        genreDao.getBooksByGenre(genreId).let { booksByGenre ->
            val books = booksByGenre.books ?: return emptyList()
            return books.map {
                BookAndGenre(it, booksByGenre.genre)
            }
        }
    }

    override fun getBooksByGenres(): List<BooksByGenre> {
        return genreDao.getBooksByGenres()
    }

    override fun getBookReviewByRating(rating: Int): List<BookAndGenre> =
        reviewDao.getReviewsByRating(rating).map {
            BookAndGenre(it.book, genreDao.getGenreById(it.book.genreId))
        }

}