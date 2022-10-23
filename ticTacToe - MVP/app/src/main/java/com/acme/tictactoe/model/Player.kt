package com.acme.tictactoe.model

import androidx.appcompat.app.AppCompatActivity
import com.acme.tictactoe.view.TicTacToeView
import android.view.ViewGroup
import android.widget.TextView
import com.acme.tictactoe.presenter.TicTacToePresenter
import android.os.Bundle
import com.acme.tictactoe.R
import android.view.MenuInflater
import com.acme.tictactoe.view.TicTacToeActivity
import com.acme.tictactoe.model.Player
import com.acme.tictactoe.model.Board.GameState
import com.acme.tictactoe.presenter.Presenter
import com.acme.tictactoe.model.Board
import kotlin.Throws
//import org.junit.Before
//import org.junit.runner.RunWith
//import org.mockito.runners.MockitoJUnitRunner
//import org.mockito.Mockito

enum class Player {
    X, O
}