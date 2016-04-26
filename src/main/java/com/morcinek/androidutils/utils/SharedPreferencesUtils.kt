package com.morcinek.androidutils.utils

import android.content.SharedPreferences

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

fun SharedPreferences.putString(preferenceKey: String, preferenceValue: String) {
    edit().putString(preferenceKey, preferenceValue).apply();
}

fun SharedPreferences.getString(preferenceKey: String): String? {
    if (contains(preferenceKey)) {
        return getString(preferenceKey, "")
    } else {
        return null
    }
}
