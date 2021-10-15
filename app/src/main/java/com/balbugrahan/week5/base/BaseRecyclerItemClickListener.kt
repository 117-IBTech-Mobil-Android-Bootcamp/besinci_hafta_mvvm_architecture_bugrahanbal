package com.balbugrahan.week5.base

import androidx.annotation.IdRes

interface BaseRecyclerItemClickListener<T> {fun onItemClicked(clickedObject: T, @IdRes id: Int = 0)}