package com.example.week_6B_solution

import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.week_6B_solution.viewmodel.ImageViewModel
import com.example.week_6B_solution.viewmodel.ImageViewModelFactory

open class ImageAppCompatActivity: AppCompatActivity() {

    // Instantiate the ViewModel from the ImageViewModelFactory
    // which extends ViewModelProvider.Factory
    protected val imageViewModel: ImageViewModel by viewModels {
        ImageViewModelFactory((application as ImageApplication).repository, application)
    }
}