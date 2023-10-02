import main.DictionaryProvider
import main.DictionaryTypes
import main.IDictionary
import main.ListDictionary

fun main(){
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
}
