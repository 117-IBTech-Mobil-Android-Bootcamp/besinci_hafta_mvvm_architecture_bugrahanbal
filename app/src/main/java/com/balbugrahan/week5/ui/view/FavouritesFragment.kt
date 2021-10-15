package com.balbugrahan.week5.ui.view

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.balbugrahan.week5.R
import com.balbugrahan.week5.adapters.FavouriteAdapter
import com.balbugrahan.week5.base.BaseFragment
import com.balbugrahan.week5.databinding.FragmentFavouritesBinding
import com.balbugrahan.week5.model.FavouriteMovieModel
import com.balbugrahan.week5.ui.viewmodel.FavouriteViewModel
import kotlinx.android.synthetic.main.fragment_favourites.*

class FavouritesFragment : BaseFragment<FavouriteViewModel, FragmentFavouritesBinding>() {

    private var favouriteList = mutableListOf<FavouriteMovieModel>()
    override var viewModel: FavouriteViewModel? = null

    override fun getLayoutID(): Int = R.layout.fragment_favourites

    override fun observeLiveData() {

        viewModel?.favResponse?.observe(this) {
            dataBinding.movie = it
            dataBinding.executePendingBindings()
            favouriteList = it.getFavouriteMovies()
            dataBinding.recyclerViewFragmentMovie.adapter = FavouriteAdapter(favouriteList)
        }
    }
    override fun prepareView() {
        viewModel?.moviesRepeat()
        if (favouriteList.size == 0){
            textView.text="There is not any seleceted Movie"
            textView.visibility= View.VISIBLE
            recyclerViewFragmentMovie.visibility = View.GONE
        }else{
            textView.visibility= View.GONE
            recyclerViewFragmentMovie.visibility = View.VISIBLE
        }
    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(FavouriteViewModel::class.java)
    }

}