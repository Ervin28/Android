import IDictionary.Companion.DICTIONARY_NAME
import java.io.File
import java.util.TreeSet


object TreeSetDictionary: IDictionary {
    private val words = TreeSet<String>()
    init {
        File(DICTIONARY_NAME).forEachLine{line-> words.add(line)}
    }
    override fun add(word: String): Boolean {
        return words.add(word)
    }

    override fun find(word: String): Boolean {
        return words.contains(word)   }

    override fun size(): Int {
        return words.size
    }
}