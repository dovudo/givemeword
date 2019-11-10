package prod.GiveMeaWord.Repostitory

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import prod.GiveMeaWord.ModelBase.Word

@Repository
interface WordsRepository: CrudRepository<Word, Int> {

    fun save(word: Word)
    fun findByLength(length:Int):Iterable<Word>
    fun existsWordByWord    (word:String):Boolean
    fun getAllByIdAfter(id: Int):Iterable<Word>
    fun findOneById(id: Int):Word
    override fun count():Long
    override fun deleteAll()
}