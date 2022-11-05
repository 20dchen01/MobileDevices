package com.lab.lab6A

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lab.lab6A.database.NumberData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NumberViewModel(application: Application) : AndroidViewModel(application) {
    private var mRepository: MyRepository = MyRepository(application)
    private var numberDataToDisplay: LiveData<NumberData?>?

    init {
        this.numberDataToDisplay = this.mRepository.getNumberData()
    }

    /**
     * getter for the live data
     * @return
     */
    fun getNumberDataToDisplay(): LiveData<NumberData?>? {
        if (this.numberDataToDisplay == null) {
            this.numberDataToDisplay = MutableLiveData<NumberData>()
        }
        //Log.d("Lab6A", "Data was sent to the view. Value: ${numberDataToDisplay?.value?.number}")
        return this.numberDataToDisplay
    }

    /**
     * request by the UI to generate a new random number
     */
    fun generateNewNumber() {
        viewModelScope.launch(Dispatchers.IO) { mRepository.generateNewNumber() }
    }
}