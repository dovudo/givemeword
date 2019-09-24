package prod.GiveMeaWord.Repostitory

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import prod.GiveMeaWord.ModelBase.Word

@Repository
interface WordsRepository: CrudRepository<Word, Long> {

    fun save(word: Word)
    fun findByLength(length:Int):Iterable<Word>
    fun existsWordByWord(word:String):Boolean
    fun getAllByIdAfter(id: Long):Iterable<Word>
    fun findOneById(id: Long):Word
    override fun count():Long
    override fun deleteAll()
}