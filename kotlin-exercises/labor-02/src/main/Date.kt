package main

import java.util.*

data class Date(val year: Int, val month: Int, val day: Int) : Comparable<Date> {
    constructor() : this(Calendar.getInstance().get(Calendar.YEAR),
        Calendar.getInstance().get(Calendar.MONTH) + 1,
        Calendar.getInstance().get(Calendar.DAY_OF_MONTH))

    override fun compareTo(other: Date): Int {
        if (year != other.year) {
            return year - other.year
        } else if (month != other.month) {
            return month - other.month
        }
        return day - other.day
    }
}

fun Date.isLeapYear(): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)
}


fun Date.isValidDate(): Boolean {
    val calendar = Calendar.getInstance()
    calendar.setLenient(false)
    calendar.set(year, month - 1, day)
    try {
        calendar.time
    } catch (e: Exception) {
        return false
    }
    return true
}

