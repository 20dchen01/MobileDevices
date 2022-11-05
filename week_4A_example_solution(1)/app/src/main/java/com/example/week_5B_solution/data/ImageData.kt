package com.example.week_5B_solution.data
//make ImageData an entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*
//make ImageData an entity
@Entity(tableName = "image_data_table")

data class ImageData {
    @PrimaryKey(autoGenerate = true)

    private val imagePath: String? = null
    private val id = 0
    private val title: String? = null
    private val description: String? = null
    private val thumbnail: String? = null
}