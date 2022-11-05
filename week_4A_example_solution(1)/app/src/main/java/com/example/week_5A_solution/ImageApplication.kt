package com.example.week_5A_solution

import android.app.Application
import com.example.week_5A_solution.data.AppDatabase

class ImageApplication: Application() {
    val databaseObj: AppDatabase by lazy { AppDatabase.getInstance(this) }
}