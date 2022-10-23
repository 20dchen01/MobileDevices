package com.acme.tictactoe.model

import com.acme.tictactoe.model.Player
import com.acme.tictactoe.model.Board.GameState
import androidx.appcompat.app.AppCompatActivity
import com.acme.tictactoe.model.Board
import android.view.ViewGroup
import android.widget.TextView
import android.os.Bundle
import com.acme.tictactoe.R
import android.view.MenuInflater
import com.acme.tictactoe.controller.TicTacToeActivity
import junit.framework.Assert
import org.junit.Before
import org.junit.Test
import kotlin.Throws

/**
 * There are a lot more tests we can and should write but for now, just a few smoke tests.
 */
class TicTacToeTests {
    private var board: Board? = null
    @Before
    fun setup() {
        board = Board()
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
        board.mark(0, 0) // x
        Assert.assertNull(board.getWinner())
        board.mark(1, 0) // o
        Assert.assertNull(board.getWinner())
        board.mark(0, 1) // x
        Assert.assertNull(board.getWinner())
        board.mark(2, 1) // o
        Assert.assertNull(board.getWinner())
        board.mark(0, 2) // x
        Assert.assertEquals(Player.X, board.getWinner())
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
        board.mark(0, 1) // x
        Assert.assertNull(board.getWinner())
        board.mark(0, 0) // o
        Assert.assertNull(board.getWinner())
        board.mark(2, 1) // x
        Assert.assertNull(board.getWinner())
        board.mark(1, 1) // o
        Assert.assertNull(board.getWinner())
        board.mark(0, 2) // x
        Assert.assertNull(board.getWinner())
        board.mark(2, 2) // o
        Assert.assertEquals(Player.O, board.getWinner())
    }
}