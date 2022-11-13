package com.example.week_6B_solution

import android.app.Application
import com.example.week_6B_solution.database.AppDatabase
import com.example.week_6B_solution.repository.ImageRepository

class ImageApplication: Application() {
    // This has been updated to initialize the repository along with the database when the
    // using by lazy again,which ensures either are created until they are
    // needed (i.e. referenced for the first time).
    val database: AppDatabase by lazy { AppDatabase.getInstance(this) }
    val repository: ImageRepository by lazy{ImageRepository(database.imageDao())}
}