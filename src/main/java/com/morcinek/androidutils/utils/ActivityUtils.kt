package com.morcinek.androidutils.utils

import android.app.Activity
import android.os.Handler
import android.os.Looper
import android.support.v4.app.DialogFragment
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

val ViewGroup.firstChild: View
    get() = getChildAt(0)

fun Activity.onUiThreadDelayed(delay: Long, f: () -> Unit) {
    Handler(Looper.getMainLooper()).postDelayed({
        if (!isFinishing) {
            f()
        }
    }, delay)
}

fun Fragment.onUiThreadDelayed(delay: Long, f: () -> Unit) {
    activity.onUiThreadDelayed (delay, f)
}

fun android.app.Fragment.setTitle(resourceId: Int) {
    (activity as AppCompatActivity).supportActionBar!!.setTitle(resourceId)
}

fun DialogFragment.show(fragmentManager: FragmentManager) {
    show(fragmentManager, javaClass.name)
}

fun Activity.finishOk() {
    setResult(Activity.RESULT_OK, intent)
    finish()
}

fun Fragment.supportInvalidateOptionsMenu() = activity.supportInvalidateOptionsMenu()
