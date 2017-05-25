package com.morcinek.androidutils.utils

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

fun <T> mergedLists(vararg elements: Collection<T>): List<T> {
    return mutableListOf<T>().apply {
        elements.forEach { addAll(it) }
    }
}

fun <T> List<T>.head(numberOfElements: Int): List<T> {
    return subList(0, Math.min(size, numberOfElements))
}

fun <K, V> Map<K, V>.valueOrDefault(key: K, default: V) = if (contains(key)) get(key)!! else default

