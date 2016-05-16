package com.morcinek.androidutils.refresh

import android.support.design.widget.AppBarLayout
import android.support.v4.widget.SwipeRefreshLayout

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */
class SwipeRefreshOnOffsetChangedListener(private val swipeRefreshLayout: SwipeRefreshLayout) : AppBarLayout.OnOffsetChangedListener {

    override fun onOffsetChanged(appBarLayout: AppBarLayout?, verticalOffset: Int) {
        swipeRefreshLayout.isEnabled = verticalOffset == 0
    }
}