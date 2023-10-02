package main

class DictionaryProvider {
    companion object{
        fun createDictionary(types: DictionaryTypes):IDictionary{
            return when(types){
                DictionaryTypes.ARRAY_LIST->ListDictionary
                DictionaryTypes.TREE_SET->HashSetDictionary
                DictionaryTypes.HASH_SET->HashSetDictionary
            }
        }
    }
}