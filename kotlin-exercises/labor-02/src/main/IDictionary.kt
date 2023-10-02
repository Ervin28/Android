package main

interface IDictionary {
    fun add(word:String):Boolean;
    fun find(keyword:String):Boolean;
    fun size():Int
    companion object{
        const val DICTIONARY_PATH="D:\\University\\IV\\Android\\kotlin-exercises\\labor-02\\src\\resources\\text"
    }
}