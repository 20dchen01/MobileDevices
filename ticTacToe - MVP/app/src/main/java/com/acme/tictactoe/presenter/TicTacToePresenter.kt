package com.acme.tictactoe.presenter

import com.acme.tictactoe.model.Board
import com.acme.tictactoe.view.TicTacToeView
//import kotlin.Throws
//import org.junit.Before
//import org.junit.runner.RunWith
//import org.mockito.runners.MockitoJUnitRunner
//import org.mockito.Mockito

class TicTacToePresenter(private val view: TicTacToeView) : Presenter {
    private lateinit var model: Board

    // Here the implement delegate functions to handle the View's lifecycle events
    override fun onPause() {}
    override fun onResume() {}
    override fun onDestroy() {}

    /**
     * The presenter provides this (and similar) functions to allow the Activity inform the
     * presenter when a button is selected. The presenter does not build a dependency on the
     * selected button. Only has the information needed from the event, i.e. row and col.
     */
    override fun onButtonSelected(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)
        if (playerThatMoved != null) {
            view.setButtonText(row, col, playerThatMoved.toString())
            model.getWinner()?.let{
                view.showWinner(it.toString())
            }
        }
    }

    override fun onCreate() {
        model = Board()
    }

    fun onResetSelected() {
        view.clearWinnerDisplay()
        view.clearButtons()
        model.restart()
    }

    init {
        model = Board()
    }
}