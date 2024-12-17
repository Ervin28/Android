interface IDictionary {
    fun add(word:String):Boolean
    fun find(word:String):Boolean
    fun size():Int
    companion object {
        const val DICTIONARY_NAME = "E:\\Egyetemi_cuccok\\IV.ev\\android\\kotlin-exercises\\labor-02\\src\\input.txt"
    }
}
