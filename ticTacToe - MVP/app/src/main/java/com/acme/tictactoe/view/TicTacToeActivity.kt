package com.acme.tictactoe.view

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.acme.tictactoe.R
import com.acme.tictactoe.presenter.TicTacToePresenter

class TicTacToeActivity : AppCompatActivity(), TicTacToeView {
    private lateinit var buttonGrid: ViewGroup
    private lateinit var winnerPlayerViewGroup: View
    private lateinit var winnerPlayerLabel: TextView
    private var presenter: TicTacToePresenter = TicTacToePresenter(this)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.tictactoe)
        winnerPlayerLabel = findViewById(R.id.winnerPlayerLabel)
        winnerPlayerViewGroup = findViewById(R.id.winnerPlayerViewGroup)
        buttonGrid = findViewById(R.id.buttonGrid)
        presenter.onCreate()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
    }

    override fun onResume() {
        super.onResume()
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reset -> {
                presenter.onResetSelected()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun onCellClicked(v: View) {
        val button = v as Button
        val tag = button.tag.toString()
        val row = Integer.valueOf(tag.substring(0, 1))
        val col = Integer.valueOf(tag.substring(1, 2))
        Log.i(TAG, "Click Row: [$row,$col]")
        presenter.onButtonSelected(row, col)
    }

    override fun setButtonText(row: Int, col: Int, text: String?) {
        val btn = buttonGrid.findViewWithTag<Button>("" + row + col)
        btn.text = text
    }

    override fun clearButtons() {
        for (i in 0 until buttonGrid.childCount) {
            (buttonGrid.getChildAt(i) as Button).text = ""
        }
    }

    override fun showWinner(winningPlayerDisplayLabel: String?) {
        winnerPlayerLabel.setText(winningPlayerDisplayLabel)
        winnerPlayerViewGroup.setVisibility(View.VISIBLE)
    }

    override fun clearWinnerDisplay() {
        winnerPlayerViewGroup.setVisibility(View.GONE)
        winnerPlayerLabel.setText("")
    }

    companion object {
        private val TAG = TicTacToeActivity::class.java.name
    }
}