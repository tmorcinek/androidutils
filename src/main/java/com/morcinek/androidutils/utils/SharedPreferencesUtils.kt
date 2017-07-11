package com.morcinek.androidutils.utils

import android.content.SharedPreferences

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

fun SharedPreferences.putString(preferenceKey: String, preferenceValue: String) {
    edit().putString(preferenceKey, preferenceValue).commit()
}

fun SharedPreferences.getString(preferenceKey: String): String? {
    if (contains(preferenceKey)) {
        return getString(preferenceKey, "")
    } else {
        return null
    }
}

fun SharedPreferences.putInt(preferenceKey: String, preferenceValue: Int) {
    edit().putInt(preferenceKey, preferenceValue).commit()
}

fun SharedPreferences.getInt(preferenceKey: String): Int {
    return getInt(preferenceKey, 0)
}

fun SharedPreferences.getIntOrNull(preferenceKey: String): Int? {
    if (contains(preferenceKey)) {
        return getInt(preferenceKey, 0)
    } else {
        return null
    }
}

fun SharedPreferences.putLong(preferenceKey: String, preferenceValue: Long) {
    edit().putLong(preferenceKey, preferenceValue).commit()
}

fun SharedPreferences.getLong(preferenceKey: String): Long? {
    if (contains(preferenceKey)) {
        return getLong(preferenceKey, 0)
    } else {
        return null
    }
}

fun SharedPreferences.putBoolean(preferenceKey: String, preferenceValue: Boolean) {
    edit().putBoolean(preferenceKey, preferenceValue).commit()
}

fun SharedPreferences.clear() {
    edit().clear().commit()
}

