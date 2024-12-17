import java.io.File

object HashSetDictionary : IDictionary {
    private val wordsSet = HashSet<String>()
    init {
        File(IDictionary.DICTIONARY_NAME).forEachLine{ line-> wordsSet.add(line)}
    }
    override fun add(word: String): Boolean {
        return wordsSet.add(word)
    }

    override fun find(word: String): Boolean {
        return wordsSet.contains(word)
    }

    override fun size(): Int {
        return wordsSet.size
    }
}