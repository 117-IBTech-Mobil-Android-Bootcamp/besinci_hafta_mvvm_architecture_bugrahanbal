package com.balbugrahan.week5.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.balbugrahan.week5.R
import com.balbugrahan.week5.databinding.RowFavBinding
import com.balbugrahan.week5.model.FavouriteMovieModel

class FavouriteAdapter(private val favList:MutableList<FavouriteMovieModel>): RecyclerView.Adapter<FavViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavViewHolder {
        return FavViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.row_fav,
                parent,
                false)
        )
    }

    override fun onBindViewHolder(holderFav: FavViewHolder, position: Int) {
        val movie = this.favList[position]
        holderFav.populate(movie)
    }

    override fun getItemCount(): Int = favList.size
}

class FavViewHolder(private val binding: RowFavBinding): RecyclerView.ViewHolder(binding.root){

    fun populate(favMovieModel: FavouriteMovieModel) {
        binding.movie = favMovieModel
        binding.executePendingBindings()
    }
}