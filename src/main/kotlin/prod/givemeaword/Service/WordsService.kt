package prod.givemeaword.Service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import prod.givemeaword.ModelBase.Word
import prod.givemeaword.Repostitory.WordsRepository
import java.util.*
import kotlin.collections.ArrayList

@Service
class WordsService(private val repository: WordsRepository){

    private val time:Benchmarks = Benchmarks("Service")
    private val log = LoggerFactory.getLogger("Word")

    /*
  * @return true if word was added
  * @return false if word was passed
  * */
    fun add(word:String):Boolean{
        time.start("Just add fun")
        return if(!checkExistWord(word)) {
                repository.save(Word(-1, word, word.length))
                time.stop()
            true
            }
            else{
            time.stop()
            false
        }
    }

    fun getByLength(length:Int):List<String> {
        val list: ArrayList<String> = ArrayList()
        repository.findByLength(length).map { list.add(it.word) }
        return list
    }

    fun getAll(id: Long) = repository.getAllByIdAfter(id)
    fun addAll(words: List<String>){
        time.start("Add all fun")
        val array: ArrayList<Word> = ArrayList()
        words.map { str -> array.add(Word(-1, str, str.length)) }
        repository.saveAll(array)
        time.stop()
    }

    fun getCollectionWordsBySize(sizeOfList:Int):List<String>{
        val sizeOfBase = getSize().toInt()
        val rnd = Random()
        val list = ArrayList<String>()
        for(i in 0 until sizeOfList){
            list.add(getById((rnd.nextInt(sizeOfBase).toLong() + 1)).word)
        }
        return list
    }

    fun getById(id:Long) = run {repository.findOneById(id)}
    fun checkExistWord(word:String):Boolean = repository.existsWordByWord(word)
    fun getSize():String = repository.count().toString()
    fun deleteAll():String{
        val count = getSize()
        repository.deleteAll()
        return "$count entity was removed"
    }
}