package com.morcinek.androidutils.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */
abstract class BaseFragment : Fragment() {

    protected abstract val layoutResourceId: Int

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(layoutResourceId, container, false)
    }
}