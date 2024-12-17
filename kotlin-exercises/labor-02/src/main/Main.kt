package main

import DictionaryProvider
import DictionaryType
import IDictionary
import Date
import java.time.LocalDate
import java.util.Random

fun exercise3(){
    val currentDate = Date() // Initializes with the current date
    println("Is the year ${currentDate.year} a leap year? ${currentDate.isLeapYear()}")

    val validDate = Date(2023, 10, 16)
    val invalidDate = Date(2023, 2, 30)

    println("Is the date $validDate valid? ${validDate.isValidDate()}")
    println("Is the date $invalidDate valid? ${invalidDate.isValidDate()}")

    val random = Random()
    val validDates = mutableListOf<Date>()

    while (validDates.size < 10) {
        val randomDate = generateRandomDate(random)
        if (randomDate.isValidDate()) {
            validDates.add(randomDate)
        } else {
            println("Invalid Date: $randomDate")
        }
    }

    println("Valid Dates:")
    val sortedDates = validDates.sorted()

    sortedDates.forEach { date ->
        println(date)
    }

    println("Reversed Dates:")
    val reversedDates = validDates.reversed()

    reversedDates.forEach { date ->
        println(date)
    }

    val customComparator = Comparator<Date> { date1, date2 ->
        if (date1.year != date2.year) {
            date1.year - date2.year
        } else if (date1.month != date2.month) {
            date1.month - date2.month
        } else {
            date1.day - date2.day
        }
    }

    println("Sorted Dates with custom comparator:")
    validDates.sortWith(customComparator)

    validDates.forEach { date ->
        println(date)
    }
}

fun generateRandomDate(random: Random): Date {
    val year = random.nextInt(1900, 2100)
    val month = random.nextInt(1, 13)
    val day = random.nextInt(1, LocalDate.of(year, month, 1).lengthOfMonth() + 1)
    return Date(year, month, day)
}

fun Date.isValidDate(): Boolean{
    return try{
        LocalDate.of(year, month, day)
        true
    } catch (e: Exception){
        false
    }
}

fun Date.isLeapYear(): Boolean{
    return LocalDate.of(year,1,1).isLeapYear
}

fun exercise2(){
    val fullName = "John Smith"
    val monogram = fullName.printMonogram()
    println("Monogram: $monogram")

    val fruits = listOf("apple", "pear", "melon")
    val result = fruits.joinWithSeparator("#")
    println(result)

    val fruits2 = listOf("apple", "pear", "strawberry", "melon")
    val longest = fruits2.findLongestString()

    if (longest != null) {
        println("Longest: $longest")
    } else {
        println("The list is empty.")
    }
}

fun List<String>.findLongestString(): String? = maxBy { it.length }

fun List<String>.joinWithSeparator(separator: String) : String = joinToString(separator)

fun String.printMonogram():String{
    val monogram = this.split(" ").map { it.first() }.joinToString(separator = "" )
    return monogram
}
fun exercise1(){
    val dict: IDictionary = DictionaryProvider().createDictionary(DictionaryType.HASH_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    while(true){
        print("What to find? ")
        word = readlnOrNull()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
}
fun main() {
    //exercise1()
    //exercise2()
    exercise3()

}