package com.example.week_3_solution

import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private lateinit var context: Context
    //make private list of ImageElement called items
    private lateinit var items: List<ImageElement>
    //make items a companion object
    companion object {
        lateinit var items: List<ImageElement>
    }


    constructor(items: Array<ImageElement>) {
        this.items = items.toList()
    }

    constructor(cont: Context, items: Array<ImageElement>) : super() {
        this.items = items.toList()
        context = cont
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        //Inflate the layout, initialize the View Holder
        val v: View = LayoutInflater.from(parent.context).inflate(
            R.layout.list_item_image,
            parent, false
        )
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        //Use the provided View Holder on the onCreateViewHolder method to populate the
        // current row on the RecyclerView
        if (items[position] != null) {
            holder.imageView.setImageResource(items[position].image)
        }
        //animate(holder);
    }

    override fun getItemCount(): Int {
        return items.size
    }

    public class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var image: Image
        var imageView: ImageView = itemView.findViewById<View>(R.id.image_item) as ImageView

    }
}