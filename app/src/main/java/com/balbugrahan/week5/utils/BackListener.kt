package com.balbugrahan.week5.utils

interface BackPressListener {

    fun isBackEnable(): Boolean
    fun onBackPressed(): Boolean
}