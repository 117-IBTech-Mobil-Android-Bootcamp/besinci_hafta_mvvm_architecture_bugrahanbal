package com.balbugrahan.week5.ui.view

import androidx.core.os.bundleOf
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.balbugrahan.week5.R
import com.balbugrahan.week5.adapters.MovieListAdapter
import com.balbugrahan.week5.base.BaseFragment
import com.balbugrahan.week5.base.BaseRecyclerItemClickListener
import com.balbugrahan.week5.databinding.FragmentMovieListBinding
import com.balbugrahan.week5.model.Movie
import com.balbugrahan.week5.ui.viewmodel.MovieListViewModel

class MovieListFragment : BaseFragment<MovieListViewModel, FragmentMovieListBinding>(){

    private val popularMovieList = mutableListOf<Movie>()
    override var viewModel: MovieListViewModel? = null
    private var adapter : MovieListAdapter? = null
    private var position : Int =0

    override fun getLayoutID(): Int =R.layout.fragment_movie_list

    override fun observeLiveData() {
        viewModel?.moviesResponse?.observe(this, {
            dataBinding.popularMovieListResponse = it
            dataBinding.executePendingBindings()
            popularMovieList.addAll(it.getList())
            adapter?.notifyItemRangeChanged(position,popularMovieList.size)
            position+=it.getList().size })}

    override fun prepareView() {

        adapter = MovieListAdapter(popularMovieList, object : BaseRecyclerItemClickListener<Movie> {
                override fun onItemClicked(clickedObject: Movie, id: Int) {
                    val bundle = bundleOf("movieId" to clickedObject.id.toString())
                    findNavController().navigate(R.id.action_homeFragment_to_detailsFragment, bundle) }
            })
        dataBinding.recyclerViewFragmentMovie.adapter = adapter
        dataBinding.recyclerViewFragmentMovie.addOnScrollListener(object :
            RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!dataBinding.recyclerViewFragmentMovie.canScrollVertically(1) &&
                    newState == RecyclerView.SCROLL_STATE_IDLE
                ) {
                    viewModel?.getMoviesWithPagination()
                }
            }
        })

    }

    override fun prepareViewModel() {
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java) }
}