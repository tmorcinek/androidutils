package com.morcinek.androidutils.utils

import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

fun Fragment.snackbar(text: Int, length: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(view!!, text, length).show()
}

fun Fragment.snackbar(text: CharSequence, length: Int = Snackbar.LENGTH_LONG) {
    Snackbar.make(view!!, text, length).show()
}
