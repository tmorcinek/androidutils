package com.morcinek.androidutils.utils

import android.os.Parcel
import android.os.Parcelable
import java.util.*

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

inline fun <reified T : Parcelable> createCreator(crossinline createFromParcel: (Parcel) -> T?) =
        object : Parcelable.Creator<T> {
            override fun createFromParcel(source: Parcel) = createFromParcel(source)
            override fun newArray(size: Int) = arrayOfNulls<T>(size)
        }

fun <T : Parcelable> Parcel.readParcelable(creator: Parcelable.Creator<T>): T? {
    if (readString() != null) return creator.createFromParcel(this) else return null
}

fun <T : Parcelable> Parcel.readParcelableList(creator: Parcelable.Creator<T>): List<T> {
    val mutableList = mutableListOf<T>()
    readTypedList(mutableList, creator)
    return mutableList
}

// Date
fun Parcel.readDate(): Date {
    return Date(readLong())
}

fun Parcel.writeDate(date: Date) = writeLong(date.time)

fun Parcel.readInteger() = readValue(null) as Int?
fun Parcel.readLongOrNull() = readValue(null) as Long?

fun Parcel.writeBoolean(boolean: Boolean) = writeValue(boolean)
fun Parcel.readBoolean() = readValue(null) as Boolean

