package com.acme.tictactoe.viewModel

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
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import kotlin.Throws

/**
 * There are a lot more tests we can and should write but for now, just a few smoke tests.
 */
class TicTacToeViewModelTests {
    private var viewModel: TicTacToeViewModel? = null
    @Before
    fun setup() {
        viewModel = TicTacToeViewModel()
    }

    private fun clickAndAssertValueAt(row: Int, col: Int, expectedValue: String?) {
        viewModel.onClickedCellAt(row, col)
        Assert.assertEquals(expectedValue, viewModel.cells["" + row + col])
    }

    /**
     * This test will simulate and verify x is the winner.
     *
     * X | X | X
     * O |   |
     * | O |
     */
    @Test
    fun test3inRowAcrossTopForX() {
        clickAndAssertValueAt(0, 0, "X")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(1, 0, "O")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(0, 1, "X")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(2, 1, "O")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(0, 2, "X")
        Assert.assertEquals("X", viewModel.winner.get())
    }

    /**
     * This test will simulate and verify o is the winner.
     *
     * O | X | X
     * | O |
     * | X | O
     */
    @Test
    fun test3inRowDiagonalFromTopLeftToBottomForO() {
        clickAndAssertValueAt(0, 1, "X")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(0, 0, "O")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(2, 1, "X")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(1, 1, "O")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(0, 2, "X")
        Assert.assertNull(viewModel.winner.get())
        clickAndAssertValueAt(2, 2, "O")
        Assert.assertEquals("O", viewModel.winner.get())
    }
}