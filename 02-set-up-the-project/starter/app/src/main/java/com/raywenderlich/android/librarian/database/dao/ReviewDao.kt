package com.raywenderlich.android.librarian.database.dao

import androidx.room.*
import com.raywenderlich.android.librarian.model.Review
import com.raywenderlich.android.librarian.model.relations.BookReview

@Dao
interface ReviewDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addReview(review: Review)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun updateReview(review: Review)

    @Transaction
    @Query("SELECT * FROM review")
    fun getReviews(): List<BookReview>

    @Transaction
    @Query("SELECT * FROM review WHERE id = :reviewId")
    fun getReviewById(reviewId: String): BookReview

    @Transaction
    @Query("SELECT * FROM review WHERE rating >= :rating")
    fun getReviewsByRating(rating: Int): List<BookReview>

    @Delete
    fun deleteReview(review: Review)
}