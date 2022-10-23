package com.example.week_3_solution

import android.os.Bundle
import android.widget.ImageView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.week_3_solution.databinding.ActivityShowImageBinding

class ShowImageActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityShowImageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_image)
// intent is a property of the activity. intent.extras returns any data that was pass
// along with the intent.
        val bundle: Bundle? = intent.extras
        var position = -1
        if (b != null) {
// this is the image position in the items List
            position = b.getInt("position")
            if (position != -1) {
                val imageView = findViewById<ImageView>(R.id.image)
                val element = MyAdapter.items[position]
                if (element.image != -1) {
                    imageView.setImageResource(element.image)
                }
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_show_image)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}