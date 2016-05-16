package com.morcinek.androidutils.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */
abstract class BaseFragment : Fragment() {

    protected abstract val layoutResourceId: Int

    open protected val menuResourceId: Int? = null

    private val hasMenu by lazy {
        menuResourceId != null
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(layoutResourceId, container, false)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(hasMenu)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        if (hasMenu) {
            inflater?.inflate(menuResourceId!!, menu)
        }
        super.onCreateOptionsMenu(menu, inflater)
    }
}