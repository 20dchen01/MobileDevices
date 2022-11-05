package com.lab.lab6A.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * This class will have a mapping SQLite table in the database.
 */
@Entity
class NumberData(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    var number: Int) {
}