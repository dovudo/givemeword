package prod.givemeaword.Service

import io.micrometer.core.annotation.Timed
import org.hibernate.query.criteria.internal.expression.function.CurrentTimeFunction
import org.springframework.stereotype.Service
import prod.givemeaword.ModelBase.Word
import prod.givemeaword.Repostitory.WordsRepository
@Service
class WordsService(private val repository: WordsRepository){

    /*
    * @return true if word was added
    * @return false if word was passed
    * */
    val time:TimeMath = TimeMath()
    @Timed
    fun add(word:String):Boolean{
        time.start()
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
    fun getById(id:Long) = repository.findOneById(id)
    fun checkExistWord(word:String):Boolean = repository.existsWordByWord(word)
    fun getSize():String {
        val count = getAll(0).count()
        return count.toString()
    }
}

