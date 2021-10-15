package com.balbugrahan.week5.ui.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.balbugrahan.week5.R
import com.balbugrahan.week5.adapters.TablayoutAdapter
import kotlinx.android.synthetic.main.fragment_home.*

class ViewPagerFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = TablayoutAdapter(childFragmentManager)
        adapter.addFragment(MovieListFragment(), "Movies")
        adapter.addFragment(FavouritesFragment(), "Favourites")
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)

    }

}