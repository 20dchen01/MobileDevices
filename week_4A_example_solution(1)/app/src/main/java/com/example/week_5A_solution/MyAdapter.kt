package com.example.week_5A_solution

import android.content.ContentResolver
import android.content.Context
import android.content.Intent
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.media.Image
import android.net.Uri
import android.os.Build
import android.util.Log
import android.util.Size
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.*
import java.io.ByteArrayOutputStream

class MyAdapter : RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private lateinit var context: Context

    companion object {
        lateinit var items: List<ImageElement>

        /**
         * All functions that could block the main thread should be marked as suspending functions.
         * This forces the consumer to dispatch them to a background thread.
         */
        private suspend fun calculateInSampleSize(options: BitmapFactory.Options, reqWidth: Int, reqHeight: Int): Int {
            // Raw height and width of image
            val height = options.outHeight; val width = options.outWidth
            var inSampleSize = 1

            if (height > reqHeight || width > reqWidth) {
                val halfHeight = (height / 2).toInt()
                val halfWidth = (width / 2).toInt()

                // Calculate the largest inSampleSize value that is a power of 2 and keeps both
                // height and width larger than the requested height and width.
                while ((halfHeight / inSampleSize) >= reqHeight
                    && (halfWidth / inSampleSize) >= reqWidth) {
                    inSampleSize *= 2;
                }
            }

            return inSampleSize.toInt();
        }

        /**
         * All functions that could block the main thread should be marked as suspending functions.
         * This forces the consumer to dispatch them to a background thread.
         *
         * Note the following changes from the sample you were originally provided:
         * signature now uses uri: Uri instread of filePath: String, and added resolver: ContentResolver
         * This is due to an error you might have observed - BitmapFactory.decodeFile failed to load the
         * image file. My current guess (yet to confirm) is that that library needs an update (since the app itself has
         * access permission to the file.
         *
         * Consequent of this, had to implement a workaround using ImageDecoder.decodeBitmap - which is able to
         * access the file and create an Bitmap object from it. It also nicely offers an option to reduce image quality
         * before the rest of the function resizes it into a thumbnail - reduced to 20% of the original quality here
         */
        suspend fun decodeSampledBitmapFromResource(uri: Uri, reqWidth: Int, reqHeight: Int, resolver: ContentResolver): Bitmap {
            return BitmapFactory.Options().run {

                var inmemoryBitmap: Bitmap? =
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
                        ImageDecoder.decodeBitmap(ImageDecoder.createSource(resolver, uri))
                    } else {
                        resolver.openInputStream(uri)?.use{
                            BitmapFactory.decodeStream(it)
                        }
                    }

                var byteArraySteam = ByteArrayOutputStream()
                var byteArray = inmemoryBitmap?.let{
                    it.compress(Bitmap.CompressFormat.JPEG, 20, byteArraySteam)
                    byteArraySteam.toByteArray()
                }

                // First decode with inJustDecodeBounds=true to check dimensions
                inJustDecodeBounds = true
                byteArray?.let { BitmapFactory.decodeByteArray(byteArray, 0, it.size, this) }
                // BitmapFactory.decodeFile(filePath, this) - old code before refactoring

                // Calculate inSampleSize
                inSampleSize = calculateInSampleSize(this, reqWidth, reqHeight)

                // Decode bitmap with inSampleSize set
                inJustDecodeBounds = false
                return byteArray?.let { BitmapFactory.decodeByteArray(byteArray, 0, it.size, this) }!!
                // note the use of kotlin null assert !! - https://kotlinlang.org/docs/null-safety.html#the-operator
            }
        }
    }

    constructor(items: List<ImageElement>) {
        MyAdapter.items = items
    }

    constructor(cont: Context, items: List<ImageElement>) : super() {
        MyAdapter.items = items
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

        // Images added from drawable resources
        items[position].image?.let {
            holder.imageView.setImageResource(it)
        }


        // Images loaded into the view
//        items[position].file_uri?.let {
//            holder.imageView.setImageURI(it)
//        }

        /**
         * Thumbnail of images loaded into the view
         */
        items[position].file_uri?.let{
            // runBlocking() create a scope within the main thread - allowing safe access to UI elements
            var file_uri = it  // the implicit "it" seems to be causing confusion

            var myBitmap: Bitmap? = null

            runBlocking {
                // launch() will start a child coroutine that uses the default dispatcher,
                // which will run outside the main thread.
                launch(Dispatchers.IO){
                        file_uri.path?.let { it ->
                            myBitmap = getThumbnail(file_uri)
                        }
                }
            }
            myBitmap?.let {
                Log.i("Lab5A", "Bitmap recieved")
                holder.imageView.setImageBitmap(myBitmap)
            }
        }

        // onClick listener added to each item in the ViewHolder
        holder.itemView.setOnClickListener(View.OnClickListener {
            val intent = Intent(context, ShowImageActivity::class.java)
            intent.putExtra("position", position)
            context.startActivity(intent)
        })
    }

    /**
     * All functions that could block the main thread should be marked as suspending functions.
     * This forces the consumer to dispatch them to a background thread.
     */
    private suspend fun getThumbnail(uri: Uri, useloadThumbnail: Boolean = false): Bitmap?{
        return if (useloadThumbnail && Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            // of course useloadThumbnail is a better option, but decodeSampledBitmapFromResource allows you to
            // better appreciate the impact of long running process.
            // Also, useloadThumbnail is only available with API 29 or greater
            context.contentResolver.loadThumbnail(uri, Size(150, 150), null)
        } else {
            // even if useThumbnailFunc is true but the API is older than 29,
            // fallback to decodeSampledBitmapFromResource
            MyAdapter.decodeSampledBitmapFromResource(uri, 150, 150, context.contentResolver)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    public class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {
        lateinit var image: Image
//        var title: TextView = itemView.findViewById<View>(R.id.title) as TextView
//        var preview: TextView = itemView.findViewById<View>(R.id.preview) as TextView
        var imageView: ImageView = itemView.findViewById<View>(R.id.image_item) as ImageView

    }
}