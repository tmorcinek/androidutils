package com.morcinek.androidutils.utils

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */
// Inline function to create Parcel Creator
inline fun <reified T : Parcelable> createParcel(crossinline createFromParcel: (Parcel) -> T?): Parcelable.Creator<T> =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel): T? = createFromParcel(source)
            override fun newArray(size: Int): Array<out T?> = arrayOfNulls(size)
        }

// custom readParcelable to avoid reflection
fun <T : Parcelable> Parcel.readParcelable(creator: Parcelable.Creator<T>): T? {
    if (readString() != null) return creator.createFromParcel(this) else return null
}

// Date
fun Parcel.readDate(): Date {
    return Date(readLong())
}

fun Parcel.writeDate(date: Date) = writeLong(date.time)
