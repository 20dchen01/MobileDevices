package com.acme.tictactoe.controller

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.acme.tictactoe.R
import com.acme.tictactoe.model.Board

class TicTacToeActivity : AppCompatActivity() {
    // The model declared as a property of the controller. Note the use of
    // lateinit to delay instantiation
    private lateinit var model: Board

    // View components referenced by the controller
    private lateinit var buttonGrid: ViewGroup
    private lateinit var winnerPlayerViewGroup: View
    private lateinit var winnerPlayerLabel: TextView

    /**
     * In onCreate of the Activity we lookup & retain references to view components
     * and instantiate the model
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictactoe)

        winnerPlayerLabel = findViewById(R.id.winnerPlayerLabel)
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup)
        buttonGrid = findViewById(R.id.buttonGrid)

        model = Board()
    }

    /**
     * A function inherited from parent class AppCompatActivity
     * and override here. Click on the upward pointing arrow beside linenumber 49 label to see more
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reset -> {
                reset()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * Similar to onOptionsItemSelected
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    /**
     * When a view event fires (in this case button clicked), this callback is invoked.
     * The method asks the model to update itself based on the user's action.
     * The method then checks if the model update is successful, and updates the view with X or O
     *
     * See the layout file res/layout/tictactoe.xml to see how this event handler is wired up
     */
    fun onCellClicked(v: View) {
        val button = v as Button

        val tag = button.tag.toString()
        val row = Integer.valueOf(tag.substring(0, 1))
        val col = Integer.valueOf(tag.substring(1, 2))

        // Log.i(TAG, "Click Row: [$row,$col]")

        // mark() returns null if the player's move was invalid (i.e. taping a cell that
        // is already taken). Returns a cell object with the player value otherwise.
        val playerThatMoved = model.mark(row, col)

        // Log.i(TAG, "Player moved: $playerThatMoved.toString()")

        playerThatMoved?.let{button.text = playerThatMoved.toString()}
        model.getWinner()?.let{
            winnerPlayerLabel.text = it.toString()
            winnerPlayerViewGroup.visibility = View.VISIBLE
        }
    }

    /**
     * Resets the view for a new game
     * Also tells the model to reset itself for a new game
     */
    private fun reset() {
        winnerPlayerViewGroup.visibility = View.GONE
        winnerPlayerLabel.text = ""
        model.restart()
        for (i in 0 until buttonGrid.childCount) {
            (buttonGrid.getChildAt(i) as Button).text = ""
        }
    }
}