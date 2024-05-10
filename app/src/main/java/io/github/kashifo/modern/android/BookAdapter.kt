package io.github.kashifo.modern.android

import android.graphics.drawable.Drawable
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DataSource
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.bumptech.glide.request.target.Target
import io.github.kashifo.modern.android.databinding.MovieLayoutBinding
import io.github.kashifo.modern.android.models.GBook


class BookAdapter : RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    val TAG = javaClass.simpleName
    private var movieList = ArrayList<GBook>()

    fun setMovieList(movieList: List<GBook>) {
        this.movieList = movieList as ArrayList<GBook>
        notifyDataSetChanged()
    }

    class ViewHolder(val binding: MovieLayoutBinding) : RecyclerView.ViewHolder(binding.root) {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            MovieLayoutBinding.inflate(
                LayoutInflater.from(
                    parent.context
                )
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        println("thumbnail:"+ movieList[position].volumeInfo.imageLinks.smallThumbnail)

        Glide.with(holder.itemView)
            .load(movieList[position].volumeInfo.imageLinks.smallThumbnail)
//            .load("https://upload.wikimedia.org/wikipedia/commons/a/a9/Example.jpg")
            .error(R.drawable.book)
            .listener(object : RequestListener<Drawable?> {
                override fun onLoadFailed(
                    e: GlideException?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    isFirstResource: Boolean
                ): Boolean {
                    Log.e(TAG, "onLoadFailed-${e?.localizedMessage}");
                    e?.printStackTrace()
                    return false
                }

                override fun onResourceReady(
                    resource: Drawable?,
                    model: Any?,
                    target: Target<Drawable?>?,
                    dataSource: DataSource?,
                    isFirstResource: Boolean
                ): Boolean {
                    return false
                }
            })
            .into(holder.binding.movieImage)

        holder.binding.movieName.text = movieList[position].volumeInfo.title
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}