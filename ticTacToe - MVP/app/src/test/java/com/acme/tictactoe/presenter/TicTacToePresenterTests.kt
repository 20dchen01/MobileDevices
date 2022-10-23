package com.acme.tictactoe.presenter

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
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Matchers
import org.mockito.Mock
import org.mockito.runners.MockitoJUnitRunner
import org.mockito.Mockito

/**
 * There are a lot more tests we can and should write but for now, just a few smoke tests.
 */
@RunWith(MockitoJUnitRunner::class)
class TicTacToePresenterTests {
    private var presenter: TicTacToePresenter? = null

    @Mock
    private val view: TicTacToeView? = null
    @Before
    fun setup() {
        presenter = TicTacToePresenter(view)
    }

    private fun clickAndAssertValueAt(row: Int, col: Int, expectedValue: String?) {
        presenter.onButtonSelected(row, col)
        Mockito.verify(view).setButtonText(row, col, expectedValue)
    }

    /**
     * This test will simulate and verify o is the winner.
     *
     * X | X | X
     * O |   |
     * | O |
     */
    @Test
    fun test3inRowAcrossTopForX() {
        clickAndAssertValueAt(0, 0, "X")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(1, 0, "O")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(0, 1, "X")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(2, 1, "O")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(0, 2, "X")
        Mockito.verify(view).showWinner("X")
    }

    /**
     * This test will simulate and verify x is the winner.
     *
     * O | X | X
     * | O |
     * | X | O
     */
    @Test
    fun test3inRowDiagonalFromTopLeftToBottomForO() {
        clickAndAssertValueAt(0, 1, "X")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(0, 0, "O")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(2, 1, "X")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(1, 1, "O")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(0, 2, "X")
        Mockito.verify(view, Mockito.never()).showWinner(Matchers.anyString())
        clickAndAssertValueAt(2, 2, "O")
        Mockito.verify(view).showWinner("O")
    }
}