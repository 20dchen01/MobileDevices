package com.acme.tictactoe.view

import androidx.appcompat.app.AppCompatActivity
import com.acme.tictactoe.viewmodel.TicTacToeViewModel
import android.os.Bundle
import android.view.Menu
import androidx.databinding.DataBindingUtil
import com.acme.tictactoe.R
import android.view.MenuItem
import com.acme.tictactoe.viewmodel.ViewModel
import com.acme.tictactoe.databinding.TictactoeBinding

class TicTacToeActivity : AppCompatActivity() {
    var myViewModel: ViewModel = TicTacToeViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = TictactoeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.viewModel = myViewModel

        myViewModel.onCreate()
    }

    override fun onPause() {
        super.onPause()
        myViewModel.onPause()
    }

    override fun onResume() {
        super.onResume()
        myViewModel.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        myViewModel.onDestroy()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.menu_tictactoe, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_reset -> {
                myViewModel.onResetSelected()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}