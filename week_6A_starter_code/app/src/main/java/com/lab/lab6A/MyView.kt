package com.lab.lab6A

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModelProvider

import com.lab.lab6A.database.NumberData
import com.lab.lab6A.databinding.ActivityMainBinding

class MyView: AppCompatActivity() {
    var stringToDisplay: LiveData<NumberData>? = null
    private var myViewModel: NumberViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
//        setContentView(R.layout.activity_main)
        setContentView(binding.root)

        // Get a new or existing ViewModel from the ViewModelProvider.
        TODO()

        // Add an observer on the LiveData. The onChanged() method fires
        // when the observed data changes and the activity is updated
        // in the foreground.
        TODO()

        // it generates a request to generate a new random number on each button click
        binding.button.setOnClickListener { this.myViewModel!!.generateNewNumber() }
    }
}