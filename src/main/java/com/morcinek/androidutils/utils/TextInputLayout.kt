package com.morcinek.androidutils.utils

import android.support.design.widget.TextInputLayout

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

fun TextInputLayout.isBlank() = editText!!.text.isBlank()

var TextInputLayout.text: String
    get() = editText!!.text.toString()
    set(value) = editText!!.setText(value)