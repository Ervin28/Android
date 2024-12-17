package main

//I.labor

//1.feladat
/*fun main() {

    val value1 = 2
    val value2 = 3

    val result = value1 + value2

    println("$value1 + $value2 = $result")
}

//2.feladat
fun main() {
    // Declare an immutable list of days of the week
    val daysOfWeek = listOf("Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday")

    // Print the entire list
    println("Days of the week:")
    for (day in daysOfWeek) {
        println(day)
    }

    // Print the days starting with the letter 'T'
    println("\nDays starting with 'T':")
    val daysStartingWithT = daysOfWeek.filter { it.startsWith("T") }
    for (day in daysStartingWithT) {
        println(day)
    }

    // Print the days containing the letter 'e'
    println("\nDays containing 'e':")
    val daysContainingE = daysOfWeek.filter { it.contains("e") }
    for (day in daysContainingE) {
        println(day)
    }

    // Print all the days of length 6
    println("\nDays of length 6:")
    val daysOfLength6 = daysOfWeek.filter { it.length == 6 }
    for (day in daysOfLength6) {
        println(day)
    }
}

//3.feladat

fun isPrime(number: Int): Boolean {
    if (number <= 1) {
        return false
    }
    if (number == 2) {
        return true
    }
    if (number % 2 == 0) {
        return false
    }
    var divisor = 3
    while (divisor * divisor <= number) {
        if (number % divisor == 0) {
            return false
        }
        divisor += 2
    }
    return true
}

fun main() {
    val rangeStart = 1
    val rangeEnd = 100

    println("Prime number int the range $rangeStart to $rangeEnd:")
    for (num in rangeStart..rangeEnd) {
        if (isPrime(num)) {
            println(num)
        }
    }
}

//4.feladat

fun encode(message: String, shift: Int): String {
    val result = StringBuilder()
    for (char in message) {
        if (char.isLetter()) {
            val shiftedChar = ((char.toInt() - 'a'.toInt() + shift) % 26 + 'a'.toInt()).toChar()
            result.append(shiftedChar)
        } else {
            result.append(char)
        }
    }
    return result.toString()
}

fun decode(encodedMessage: String, shift: Int): String {
    return encode(encodedMessage, 26 - shift) // Decoding is essentially encoding with the opposite shift
}

fun applyEncodingOrDecoding(message: String, operation: (String, Int) -> String, shift: Int): String {
    return operation(message, shift)
}

fun main() {
    val originalMessage = "hello world"
    val shift = 3

    // Encoding
    val encodedMessage = applyEncodingOrDecoding(originalMessage, ::encode, shift)
    println("Encoded message: $encodedMessage")

    // Decoding
    val decodedMessage = applyEncodingOrDecoding(encodedMessage, ::decode, shift)
    println("Decoded message: $decodedMessage")
}
*/
//5.feladat
/*
fun printEvenNumbers(numbers: List<Int>) = numbers.filter {
    it % 2 == 0
}.forEach { println(it) }

fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    println("Even numbers:")
    printEvenNumbers(numbers)
}
*/
/*
//6.exercise
fun main() {
    val numbers = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)

    //doubled
    val doubledNumbers = numbers.map { it * 2 }
    println("Doubled numbers: $doubledNumbers")

    //capitalized
    val daysOfWeek = listOf("sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday")

    val capitalizedDaysOfWeek = daysOfWeek.map { it.toUpperCase() }

    capitalizedDaysOfWeek.forEach { println(it) }

    //first letter capitalized
    val firstCharCapitalizedDays = daysOfWeek.map { it.first().toUpperCase() }

    firstCharCapitalizedDays.forEach { println(it) }

    //day length
    val dayLengths = daysOfWeek.map { it.length }

    dayLengths.forEach { println(it) }

    //average length
    val totalLength = daysOfWeek.sumBy { it.length }
    val averageLength = totalLength.toDouble() / daysOfWeek.size

    println("Average length of days: $averageLength")
}
*//*
//7. exercise
fun main(){
    val daysOfWeek = listOf("sunday", "monday", "tuesday", "wednesday", "thursday", "friday", "saturday")

    //remove words containing 'n"
    val filteredDays = daysOfWeek.filter { !it.contains('n', ignoreCase = true) }

    println(filteredDays)

    //items with index
    for ((index, day) in daysOfWeek.withIndex()) {
        println("$index: $day")
    }

    //sorted list
    val sortedDays = daysOfWeek.sorted()

    println(sortedDays)
}
*/
//8. exercise
import kotlin.random.Random

fun main() {
    //random 10 integer in range of 0-100
    val random = Random.Default
    val randomIntegers = List(10) { random.nextInt(0, 101) }

    randomIntegers.forEach { println(it) }

    //sorted integers
    val sortedIntegers = randomIntegers.sorted()

    sortedIntegers.forEach { println(it) }

    //contains even or not
    val containsEven = randomIntegers.any { it % 2 == 0 }

    if (containsEven) {
        println("The array contains at least one even number.")
    } else {
        println("The array does not contain any even numbers.")
    }
    // all even or not
    val allEven = randomIntegers.all { it % 2 == 0 }

    if (allEven) {
        println("All numbers in the array are even.")
    } else {
        println("Not all numbers in the array are even.")
    }
    //average of generated numbers
    val sum = randomIntegers.sum()
    val average = if (randomIntegers.isNotEmpty()) sum.toDouble() / randomIntegers.size else 0.0

    randomIntegers.forEach {
        println("Number: $it")
    }

    println("Average: $average")
}