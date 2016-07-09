package com.morcinek.androidutils.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.support.v4.app.Fragment
import org.jetbrains.anko.internals.AnkoInternals

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

inline fun <reified T : Activity> Context.startActivity(vararg params: Any) {
    val arrayOfPairs = params.map { Pair(it.javaClass.name, it) }.toTypedArray()
    AnkoInternals.internalStartActivity(this, T::class.java, arrayOfPairs)
}

fun Context.startActionViewActivity(url: String) {
    startActivity(Intent(Intent.ACTION_VIEW, Uri.parse(url)))
}

inline fun <reified T : Activity> Context.startActivityWithFlags(intentFlags: Int) {
    startActivity(Intent(this, T::class.java).apply {
        flags = intentFlags
    })
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

inline fun <reified T : Activity> Fragment.startActivity(vararg params: Any) {
    val arrayOfPairs = params.map { Pair(it.javaClass.name, it) }.toTypedArray()
    AnkoInternals.internalStartActivity(context, T::class.java, arrayOfPairs)
}
