package main

import java.io.File

object ListDictionary:IDictionary {
    private val words= mutableListOf<String>()

    init{
        File(IDictionary.DICTIONARY_PATH).forEachLine {words.add(it)}

    }

    override fun add(word: String): Boolean {
       return words.add(word)
    }

    override fun find(keyword: String): Boolean {
        return words.any { it == keyword }
    }


    override fun size(): Int {
       return words.size;
    }


}