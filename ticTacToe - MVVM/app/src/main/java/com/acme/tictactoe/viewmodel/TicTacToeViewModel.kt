package com.acme.tictactoe.viewmodel

import com.acme.tictactoe.model.Board
import androidx.databinding.ObservableArrayMap
import androidx.databinding.ObservableField

class TicTacToeViewModel : ViewModel {
    private var model: Board = Board()

    override val cells: ObservableArrayMap<String, String> = ObservableArrayMap()
    override val winner: ObservableField<String> = ObservableField()

    // As with presenter, we implement standard lifecycle methods from the view
    // in case we need to do anything with our model during those events.
    override fun onCreate() {}
    override fun onPause() {}
    override fun onResume() {}
    override fun onDestroy() {}

    /**
     * An Action, callable by the view.  This action will pass a message to the model
     * from the button clicked and then update the observable fields with the current
     * model state.
     */
    override fun onClickedCellAt(row: Int, col: Int) {
        val playerThatMoved = model.mark(row, col)
        cells["$row$col"] = playerThatMoved?.toString()
        winner.set(model.getWinner()?.toString())
    }

    /**
     * An Action, callable by the view.  This action will pass a message to the model
     * to restart and then clear the observable data in this ViewModel.
     */
    override fun onResetSelected() {
        model.restart()
        winner.set(null)
        cells.clear()
    }

}