package com.acme.tictactoe.model

import androidx.appcompat.app.AppCompatActivity
import com.acme.tictactoe.viewmodel.TicTacToeViewModel
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.acme.tictactoe.R
import android.view.MenuInflater
import com.acme.tictactoe.model.Player
import com.acme.tictactoe.model.Board.GameState
import com.acme.tictactoe.model.Board
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField
import kotlin.Throws

/**
 * Created by ericmaxwell on 1/19/17.
 */
class Cell {
    var value: Player? = null
}