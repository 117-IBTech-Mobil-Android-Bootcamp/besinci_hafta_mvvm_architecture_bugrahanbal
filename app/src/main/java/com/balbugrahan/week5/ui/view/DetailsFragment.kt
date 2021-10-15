package com.balbugrahan.week5.ui.view

import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.balbugrahan.week5.R
import com.balbugrahan.week5.base.BaseFragment
import com.balbugrahan.week5.databinding.FragmentDetailsBinding
import com.balbugrahan.week5.ui.viewmodel.DetailsListViewModel
import kotlinx.android.synthetic.main.fragment_details.*

class DetailsFragment : BaseFragment<DetailsListViewModel, FragmentDetailsBinding>() {
    override fun shouldCheckInternetConnection(): Boolean {
        return true }
    var bundleGet: String? = null
    private var title: String? = null
    private var boolean: Boolean = false
    override var viewModel: DetailsListViewModel? = null
    override fun getLayoutID(): Int = R.layout.fragment_details
    override fun observeLiveData() {
        viewModel?.moviesDetailsResponse?.observe(this, {
            dataBinding.movieDetails = it
            dataBinding.executePendingBindings()
            title = it.getTitle()
        }) }
    override fun prepareView() {
        val sharedPreferences: SharedPreferences =
            requireActivity().getSharedPreferences("Shared", MODE_PRIVATE)
        val edit = sharedPreferences.edit()
        if (sharedPreferences.contains(arguments?.getString("movieId"))) {
            dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_filled)
            boolean = true
            edit.remove(arguments?.getString("movieId"))
            edit.apply()
        } else {
            dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_unfilled)
            boolean = false
            edit.putString(arguments?.getString("movieId"), title)
            edit.apply() }
        dataBinding.addFavouriteButton.setOnClickListener {
            if (boolean) {
                dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_unfilled)
                boolean = false
                sharedPreferences.edit().remove(arguments?.getString("movieId")).apply()
                edit.remove(arguments?.getString("movieId"))
                edit.commit()
            } else {
                dataBinding.addFavouriteButton.setImageResource(R.drawable.ic_heart_filled)
                boolean = true
                edit.putString(arguments?.getString("movieId"), title)
                edit.apply() }
            val myEdit = sharedPreferences.edit()
            myEdit.putString(arguments?.getString("movieId"), title)
            myEdit.apply()
        }
        backButton.setOnClickListener(View.OnClickListener {
            val action =DetailsFragmentDirections.actionDetailsFragmentToHomeFragment()
            view?.let { it1 -> Navigation.findNavController(it1).navigate(action) }
        })
    }
    override fun prepareViewModel() {
        viewModel = ViewModelProvider(
            this,
            viewModelFactory { DetailsListViewModel(arguments?.getString("movieId")!!) }
        ).get(DetailsListViewModel::class.java)
        bundleGet = arguments?.getString("movieId")
    }
}