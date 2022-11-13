package com.example.week_6B_solution.database

import android.content.Context
import android.net.Uri
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey
import com.example.week_6B_solution.model.Image
import com.example.week_6B_solution.utils.getOrMakeThumbNail

@Entity(tableName = "image", indices=[Index(value=["id", "image_title"])])
data class ImageEntity (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @ColumnInfo(name="image_path") val imagePath: String,
    @ColumnInfo(name="image_title") var title: String,
    @ColumnInfo(name="image_description") var description: String?,
    @ColumnInfo(name="thumbnail_filename") var thumbnail: String?)
