package main

import java.util.*
import kotlin.random.Random

//1
fun addNumbers(a:Int,b:Int) {
    val sum = a + b
    println("$a + $b = $sum")
}
fun isPrime(num: Int): Boolean {
    if (num < 2) {
        return false
    }
    for (i in 2 until num) {
        if (num % i == 0) {
            return false
        }
    }
    return true
}

fun isEven(a:Int)=a%2==0
//4
fun encode (s:String):String{
    return Base64.getEncoder().encodeToString(s.toByteArray())
}
fun decode(s:String): String {
    return String(Base64.getDecoder().decode(s))
}
fun main(args: Array<String>) {
    println("***************Firs exercise************")
    addNumbers(10,6)

    println("***************Second exercise************")

    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    // Print all days
    println("All days of the week:")
    for (day in daysOfWeek) {
        println(day)
    }

    // Print days starting with 'T'
    println("\nDays starting with 'T':")
    val daysStartingWithT = daysOfWeek.filter { it.startsWith("T") }
    println(daysStartingWithT)

    // Print days containing the letter 'e'
    println("\nDays containing the letter 'e':")
    val daysWithE = daysOfWeek.filter { it.contains("e") }
    println(daysWithE)

    // Print days of length 6
    println("\nDays of length 6:")
    val daysLength6 = daysOfWeek.filter { it.length == 6 }
    println(daysLength6)
    println("***************Third exercise************")
    println("7 is prime?: "+isPrime(7))
    println("6 is prime?: "+isPrime(6))
    val rangeStart = 1
    val rangeEnd = 20
    println("Prime numbers between $rangeStart and $rangeEnd:")
    for (num in rangeStart..rangeEnd) {
        if (isPrime(num)) {
            print("$num ")
        }
    }
    println("\n***************Fourth exercise************")
    println("Given the word: kukac")
    val text= encode("kukac")
    println("encoded text: "+text)
    println("decoded text: "+decode(text))

    println("\n***************Fifth exercise************")
    println("3 is even?: "+isEven(3))
    println("4 is even?: "+isEven(4))

    println("\n***************Sixth exercise************")
    // Double the elements of a list of integers
    val numbers = listOf(1, 2, 3, 4, 5)
    val doubledNumbers = numbers.map { it * 2 }
    println("Doubled numbers: $doubledNumbers")

    // Print the days of the week capitalized
    val capitalizedDays = daysOfWeek.map { it.toUpperCase() }
    println("Days of the week capitalized: $capitalizedDays")

    // Print the first character of each day capitalized
    val firstCharCapitalized = daysOfWeek.map { it.first().toUpperCase() }
    println("First character of each day capitalized: $firstCharCapitalized")

    // Print the length of days
    val lengthsOfDays = daysOfWeek.map { it.length }
    println("Length of days: $lengthsOfDays")

    // Compute the average length of days
    val averageLength = lengthsOfDays.average()
    println("Average length of days: $averageLength")

    println("\n***************Seven exercise************")
    // Convert the daysOfWeek immutable list into a mutable one
    val daysOfWeek_2 = mutableListOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    // Remove all days containing the letter 'n'
    daysOfWeek_2.removeIf { it.contains("n") }

    // Print the mutable list after removal
    println("Days after removing those containing 'n': $daysOfWeek_2")

    // Print each element of the list with its index
    println("\nList elements with index:")
    for ((index, value) in daysOfWeek_2.withIndex()) {
        println("Item at $index is $value")
    }

    // Sort the result list alphabetically
    daysOfWeek_2.sort()

    // Print the sorted list
    println("\nSorted list alphabetically: $daysOfWeek_2")
    println("\n***************Eight exercise************")

    // Generate an array of 10 random integers between 0 and 100
    val randomIntegers = IntArray(10) { Random.nextInt(0, 101) }

    // Use forEach to print each element of the array in a new line
    println("Array elements:")
    randomIntegers.forEach { println(it) }

    // Print the array sorted in ascending order
    val sortedArray = randomIntegers.sorted().toTypedArray()
    println("\nSorted array in ascending order: ${sortedArray.joinToString()}")

    // Check whether the array contains any even number
    val containsEven = randomIntegers.any { it % 2 == 0 }
    println("\nDoes the array contain any even number? $containsEven")

    // Check whether all the numbers are even
    val allEven = randomIntegers.all { it % 2 == 0 }
    println("Are all numbers even? $allEven")

    // Calculate the average of generated numbers and print it using forEach
    var sum = 0
    randomIntegers.forEach { sum += it }
    val average = sum / randomIntegers.size.toDouble()
    println("\nAverage of generated numbers: $average")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")
}