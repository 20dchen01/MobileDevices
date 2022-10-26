package com.example.week_3_solution

import android.content.Context
import android.content.Intent
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private lateinit var context: Context
    //make private list of ImageElement called items

    companion object {
        lateinit var items: List<ImageElement>
    }


    constructor(items: MutableList<ImageElement>) {
        MyAdapter.items = items.toList()
    }

    constructor(cont: Context, items: Array<ImageElement>) : super() {
        MyAdapter.items = items.toList()
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
        if (items[position].image != -1) {
//            holder.title.text = items[position].title
//            holder.preview.text = items[position].preview
            holder.imageView.setImageResource(items[position].image)

            // onClick listener added to each item in the ViewHolder
            holder.itemView.setOnClickListener(View.OnClickListener {
                val intent = Intent(context, ShowImageActivity::class.java)
                intent.putExtra("position", position)
                context.startActivity(intent)
            })
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    public class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var image: Image
        var imageView: ImageView = itemView.findViewById<View>(R.id.image_item) as ImageView

    }
}