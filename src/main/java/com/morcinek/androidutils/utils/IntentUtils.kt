package com.morcinek.androidutils.utils

import android.content.Intent
import android.os.Parcelable
import java.io.Serializable

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

inline fun <reified T : Parcelable> Intent.getParcelableExtra() = getParcelableExtra<T>(T::class.java.name)

inline fun <reified T : Serializable> Intent.getSerializableExtra() = getSerializableExtra(T::class.java.name) as T?

fun <T : Parcelable> Intent.putParcelableExtra(value: T) = putExtra(value.javaClass.getName(), value)
fun <T : Serializable> Intent.putSerializableExtra(value: T) = putExtra(value.javaClass.getName(), value)
fun Intent.getStringExtra() = getStringExtra(String::class.java.name)
