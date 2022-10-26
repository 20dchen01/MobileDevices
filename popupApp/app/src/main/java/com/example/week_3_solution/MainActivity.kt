package com.example.week_3_solution

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.activity.result.contract.ActivityResultContracts
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    private lateinit var mRecyclerView: RecyclerView
    private lateinit var mAdapter:RecyclerView.Adapter<RecyclerView.ViewHolder>
    //    private lateinit var mLayoutManager: RecyclerView.LayoutManager
    private val myDataset: MutableList<ImageElement> = ArrayList<ImageElement>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbar)

        mRecyclerView = findViewById<RecyclerView>(R.id.my_list)

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        //mRecyclerView.setHasFixedSize(true);

        // use a linear layout manager
        val numberOfColumns = 4
        mRecyclerView.layoutManager = GridLayoutManager(this, numberOfColumns)

        // specify an adapter (see also next example)
        mAdapter = MyAdapter(this, myDataset) as RecyclerView.Adapter<RecyclerView.ViewHolder>
        mRecyclerView.adapter = mAdapter
        val fab: FloatingActionButton = findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(View.OnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        })
    }

    private fun initData() {
        repeat(1000){
            myDataset.add(ImageElement(R.drawable.joe1))
            myDataset.add(ImageElement(R.drawable.joe2))
            myDataset.add(ImageElement(R.drawable.joe3))
        }
    }
    val photoPicker = registerForActivityResult(ActivityResultContracts.PickVisualMedia()) { uri ->
        if (uri != null) {
            val element = ImageElement(uri)
            myDataset.add(element)
            mRecyclerView.scrollToPosition(myDataset.size - 1)
        }
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id = item.itemId
        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
}