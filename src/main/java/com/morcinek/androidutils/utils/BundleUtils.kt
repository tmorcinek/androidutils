package com.morcinek.androidutils.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Parcelable
import android.support.v4.app.Fragment
import org.jetbrains.anko.internals.AnkoInternals
import java.io.Serializable

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

inline fun <reified T : Parcelable> Bundle.getParcelable(): T? = getParcelable(T::class.java.name)

inline fun <reified T : Parcelable> Intent.getParcelableExtra() = getParcelableExtra<T>(T::class.java.name)
inline fun <reified T : Serializable> Intent.getSerializableExtra() = getSerializableExtra(T::class.java.name) as T?

fun <T : Parcelable> Intent.putParcelableExtra(value: T) = putExtra(value.javaClass.getName(), value)
fun <T : Serializable> Intent.putSerializableExtra(value: T) = putExtra(value.javaClass.getName(), value)

inline fun <reified T : Activity> Context.startActivity(vararg params: Any) {
    val arrayOfPairs = params.map { Pair(it.javaClass.name, it) }.toTypedArray()
    AnkoInternals.internalStartActivity(this, T::class.java, arrayOfPairs)
}

fun Context.startActionViewActivity(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}

inline fun <reified T : Activity> Fragment.startActivity(vararg params: Any) {
    val arrayOfPairs = params.map { Pair(it.javaClass.name, it) }.toTypedArray()
    AnkoInternals.internalStartActivity(context, T::class.java, arrayOfPairs)
}

inline fun <reified T : Activity> Activity.startActivityForResult(vararg params: Any) {
    val arrayOfPairs = params.map { Pair(it.javaClass.name, it) }.toTypedArray()
    AnkoInternals.internalStartActivityForResult(this, T::class.java, 0, arrayOfPairs)
}

inline fun <reified T : Activity> Fragment.startActivityForResult(vararg params: Any) {
    val arrayOfPairs = params.map { Pair(it.javaClass.name, it) }.toTypedArray()
    val intent = AnkoInternals.createIntent(activity, T::class.java, arrayOfPairs)
    activity.startActivityFromFragment(this, intent, 0)
}