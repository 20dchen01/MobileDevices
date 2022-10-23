package com.acme.tictactoe.viewmodel

import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField

interface ViewModel {
    val cells: ObservableArrayMap<String, String>
    val winner: ObservableField<String>

    fun onCreate()
    fun onPause()
    fun onResume()
    fun onDestroy()
    fun onClickedCellAt(row: Int, col: Int)
    fun onResetSelected()
}