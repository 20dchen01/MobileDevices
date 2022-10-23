package com.acme.tictactoe.model

//import androidx.test.ext.junit.runners.AndroidJUnit4

class Board {
    private inline fun <reified T> matrixOfNulls(n: Int, m: Int) = Array(n) { arrayOfNulls<T>(m) }
    private val cells = matrixOfNulls<Cell>(3, 3) // example arguments - sets size of board
    private var winner: Player? = null
    private lateinit var state: GameState
    private lateinit var currentTurn: Player

    enum class GameState {
        IN_PROGRESS, FINISHED
    }

    /**
     * Restart or start a new game, will clear the board and win status
     */
    fun restart() {
        clearCells()
        winner = null
        currentTurn = Player.X // X always starts.
        state = GameState.IN_PROGRESS
    }

    /**
     * Mark the current row for the player who's current turn it is.
     * Will perform no-op if the arguments are out of range or if that position is already played.
     * Will also perform a no-op if the game is already over.
     *
     * @param row 0..2
     * @param col 0..2
     */
    fun mark(row: Int, col: Int): Player? {
        if (isValid(row, col)) {
            cells[row][col]?.value = currentTurn
            if (isWinningMoveByPlayer(currentTurn, row, col)) {
                state = GameState.FINISHED
                winner = currentTurn
            } else {
                // flip the current turn and continue
                flipCurrentTurn()
            }
        }
        return cells[row][col]?.value
    }

    fun getWinner(): Player? {
        return winner
    }

    private fun clearCells() {
        for (i in 0..2) {
            for (j in 0..2) {
                cells[i][j] = Cell()
            }
        }
    }

    private fun isValid(row: Int, col: Int): Boolean {
        return if (state == GameState.FINISHED) {
            false
        } else if (isOutOfBounds(row) || isOutOfBounds(col)) {
            false
        } else !isCellValueAlreadySet(row, col)
    }

    private fun isOutOfBounds(idx: Int): Boolean {
        return idx < 0 || idx > 2
    }

    private fun isCellValueAlreadySet(row: Int, col: Int): Boolean {
        return cells[row][col]?.value != null
    }

    /**
     * Algorithm adapted from http://www.ntu.edu.sg/home/ehchua/programming/java/JavaGame_TicTacToe.html
     * @param player
     * @param currentRow
     * @param currentCol
     * @return true if `player` who just played the move at the `currentRow`, `currentCol`
     * has a tic tac toe.
     */
    private fun isWinningMoveByPlayer(player: Player?, currentRow: Int, currentCol: Int): Boolean {
        return (cells[currentRow][0]?.value == player // 3-in-the-row
                && cells[currentRow][1]?.value == player && cells[currentRow][2]?.value == player
                ) || (cells[0][currentCol]?.value == player // 3-in-the-column
                && cells[1][currentCol]?.value == player && cells[2][currentCol]?.value == player
                ) || (currentRow == currentCol // 3-in-the-diagonal
                && cells[0][0]?.value == player && cells[1][1]?.value == player && cells[2][2]?.value == player
                ) || (currentRow + currentCol == 2 // 3-in-the-opposite-diagonal
                && cells[0][2]?.value == player && cells[1][1]?.value == player && cells[2][0]?.value == player)
    }

    private fun flipCurrentTurn() {
        currentTurn = if (currentTurn == Player.X) Player.O else Player.X
    }

    init {
        restart()
    }
}