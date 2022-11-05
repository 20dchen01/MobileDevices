package com.lab.lab6A

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel

import com.lab.lab6A.database.NumberDao
import com.lab.lab6A.database.AppDatabase
import com.lab.lab6A.database.NumberData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*


class MyRepository(application: Application) {
    private var mDBDao: NumberDao? = null

    init {
        val db: AppDatabase? = TODO()
    }

    companion object {
        private val scope = CoroutineScope(Dispatchers.IO)
        private class InsertAsyncTask(private val dao: NumberDao?) : ViewModel() {
            suspend fun insertInBackground(vararg params: NumberData) {
                scope.launch {
                    for(param in params){
                        val insertedId: Int? = this@InsertAsyncTask.dao?.insert(param)?.toInt()
                        // you may want to check if insertedId is null to confirm successful insertion
                        //Log.i("MyRepository", "number generated: " + param.number.toString()
                        //        + ", inserted with id: " + insertedId.toString() + "")
                    }
                }
            }
        }
    }

    /**
     * it gets the data when changed in the db and returns it to the ViewModel
     * @return
     */
    fun getNumberData() = TODO()

    /**
     * called by the UI to request the generation of a new random number
     */
    suspend fun generateNewNumber() = TODO()
}