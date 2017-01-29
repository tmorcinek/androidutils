package com.morcinek.androidutils.utils

import android.os.Bundle
import android.os.Parcelable
import java.io.Serializable

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

inline fun <reified T : Parcelable> Bundle.getParcelable(): T? = getParcelable(T::class.java.name)

inline fun <reified T : Serializable> Bundle.getSerializable(): T? = getSerializable(T::class.java.name) as T?

fun <T : Parcelable> Bundle.putParcelable(value: T) = putParcelable(value.javaClass.getName(), value)
fun <T : Serializable> Bundle.putSerializable(value: T) = putSerializable(value.javaClass.getName(), value)

fun Bundle.getInt() = getInt(Int::class.java.name)
fun Bundle.put(value: Int) = putInt(Int::class.java.name, value)
