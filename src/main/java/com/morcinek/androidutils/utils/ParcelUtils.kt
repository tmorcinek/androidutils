package com.morcinek.androidutils.utils

import android.os.Parcel

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

fun Parcel.readInteger() = readValue(null) as Int?