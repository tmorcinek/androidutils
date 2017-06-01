package com.morcinek.androidutils.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Copyright 2016 Tomasz Morcinek. All rights reserved.
 */

fun Calendar.toString(format: String) = SimpleDateFormat(format).format(time)

val Calendar.month: Int
    get() = get(Calendar.MONTH)

val Calendar.year: Int
    get() = get(Calendar.YEAR)

val Calendar.dayOfYear: Int
    get() = get(Calendar.DAY_OF_YEAR)

val Calendar.weekOfYear: Int
    get() = get(Calendar.WEEK_OF_YEAR)

var Calendar.dayOfWeek: Int
    get() = get(Calendar.DAY_OF_WEEK)
    set(value) = set(Calendar.DAY_OF_WEEK, value)

var Calendar.dayOfMonth: Int
    get() = get(Calendar.DAY_OF_MONTH)
    set(value) = set(Calendar.DAY_OF_MONTH, value)

fun Calendar.isSameMonth(otherDate: Calendar) = year == otherDate.year && month == otherDate.month

fun Calendar.isSameDay(otherDate: Calendar) = year == otherDate.year && dayOfYear == otherDate.dayOfYear

fun Calendar.isSameWeek(otherDate: Calendar) = year == otherDate.year && weekOfYear == otherDate.weekOfYear

fun Calendar.plusDays(number: Int) = add(Calendar.DAY_OF_MONTH, number)

fun Calendar.minusDays(number: Int) = add(Calendar.DAY_OF_MONTH, -number)

fun Calendar.minusWeeks(number: Int) = add(Calendar.WEEK_OF_YEAR, -number)

fun Calendar.minusMonth(number: Int) = add(Calendar.MONTH, -number)

fun Calendar.resetFirstDayOfWeek() = apply { dayOfWeek = Calendar.MONDAY }

fun Calendar.resetFirstDayOfMonth() = apply { dayOfMonth = 1 }

fun Calendar.resetTime() {
    set(Calendar.HOUR_OF_DAY, 0);            // set hour to midnight
    set(Calendar.MINUTE, 0);                 // set minute in hour
    set(Calendar.SECOND, 0);                 // set second in minute
    set(Calendar.MILLISECOND, 0);
}

operator fun Calendar.rangeTo(other: Calendar) = CalendarRange(this, other)

fun Calendar.nextDay(): Calendar {
    val day = clone() as Calendar
    day.plusDays(1)
    return day
}

class CalendarRange(val start: Calendar, val endInclusive: Calendar) : Iterable<Calendar> {

    override fun iterator(): Iterator<Calendar> = CalendarIterator(this)

    operator fun contains(date: Calendar): Boolean = date > start && date < endInclusive
}

class CalendarIterator(val range: CalendarRange) : Iterator<Calendar> {

    var currentDate: Calendar = range.start

    override fun next(): Calendar {
        currentDate = currentDate.nextDay()
        return currentDate
    }

    override fun hasNext() = currentDate.nextDay() in range
}
