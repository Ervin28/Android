import main.*
import main.Date
import java.util.*

fun String.nameMongoram():String=this.split(" ").map{it[0]}.joinToString("")
fun List<String>.withSeparator(separator: String): String {
    return this.joinToString(separator)
}
fun List<String>.findLongestString(): String? {
    return this.maxByOrNull { it.length }
}
fun main(){
    println("\n*************** Prblem 1 ************")

    //Problem 1
    val dict: IDictionary = DictionaryProvider.createDictionary(DictionaryTypes.HASH_SET)
    println("Number of words: ${dict.size()}")
    var word: String?
    dict.add("kukac")
    while(true){
        print("What to find? ")
        word = readLine()
        if( word.equals("quit")){
            break
        }
        println("Result: ${word?.let { dict.find(it) }}")
    }
    println("\n*************** Problem 2 ************")

    //Problem 2 a
    val name="John Smith"
    println("John Smith monogram is: "+name.nameMongoram())
    //Problem 2 b
    val stringList = listOf("apple", "pear", "melon")
    val result = stringList.withSeparator("+")
    println(result)
    //Problem 2 c
    val longestString = stringList.findLongestString()
    if (longestString != null) {
        println("Longest string: $longestString")
    } else {
        println("The list is empty.")
    }

    //Problem 3
    println("\n*************** Problem 3 ************")

    val validDates = mutableListOf<Date>()
    val random = Random()

    while (validDates.size < 10) {
        val generatedDate = Date(random.nextInt(3000) + 1, random.nextInt(12) + 1, random.nextInt(31) + 1)
        if (generatedDate.isValidDate()) {
            validDates.add(generatedDate)
        } else {
            println("Invalid date: $generatedDate")
        }
    }

    println("Valid Dates:")
    validDates.forEach { println(it) }

    validDates.sort()
    println("\nSorted Dates:")
    validDates.forEach { println(it) }

    validDates.reverse()
    println("\nReversed Sorted Dates:")
    validDates.forEach { println(it) }

    val customOrder = compareBy<Date> { it.month }.thenBy { it.day }.thenBy { it.year }
    validDates.sortWith(customOrder)
    println("\nCustom Ordered Dates:")
    validDates.forEach { println(it) }
}
