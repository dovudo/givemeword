package prod.givemeaword.Service

import org.springframework.stereotype.Service
import prod.givemeaword.ModelBase.Word
import prod.givemeaword.Repostitory.wordsRepository
@Service
class wordsService(private val repository: wordsRepository){

    /*
    * @return true if word was added
    * @return false if word was passed
    * */
    fun add(word:String):Boolean{
        return if(!checkExistWord(word)) {
            val newWord = Word(-1, word, word.length)
            repository.save(newWord)
            true
        }
        else
            false
    }
    fun getByLength(length:Int):List<String> {
        val list: ArrayList<String> = ArrayList()
        repository.findByLength(length).map { list.add(it.word) }
        return list
    }
    fun getAll(id: Long) = repository.getAllByIdAfter(id)
    fun getById(id:Long) = repository.findOneById(id)
    fun checkExistWord(word:String):Boolean = repository.existsWordByWord(word)
    fun getSize():String {
        val count = getAll(0).count()
        return count.toString()
    }
}

