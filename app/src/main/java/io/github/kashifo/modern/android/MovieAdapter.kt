package io.github.kashifo.modern.android

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import io.github.kashifo.modern.android.databinding.MovieLayoutBinding
import io.github.kashifo.modern.android.models.GBook


class MovieAdapter : RecyclerView.Adapter<MovieAdapter.ViewHolder>() {
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

        println(movieList[position].volumeInfo.imageLinks.smallThumbnail)

        Glide.with(holder.itemView)
            .load(movieList[position].volumeInfo.imageLinks.smallThumbnail)
//            .load("https://upload.wikimedia.org/wikipedia/commons/e/ee/Sample_abc.jpg")
            .into(holder.binding.movieImage)
        holder.binding.movieName.text = movieList[position].volumeInfo.title
    }

    override fun getItemCount(): Int {
        return movieList.size
    }
}