package com.lab.lab6A.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query

/*
 * define database interactions
 */
@Dao
interface NumberDao {
    @Insert
    fun insertAll(vararg numberData: NumberData?)

    @Insert
    fun insert(numberData: NumberData): Long

    @Delete
    fun delete(numberData: NumberData?)

    // it selects a random element
    @Query("SELECT * FROM numberData ORDER BY RANDOM() LIMIT 1")
    fun retrieveOneNumber(): LiveData<NumberData?>?

    @Delete
    fun deleteAll(vararg numberData: NumberData?)

    @Query("SELECT COUNT(*) FROM numberData")
    fun howManyElements(): Int
}