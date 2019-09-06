package prod.givemeaword.Repostitory

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import prod.givemeaword.ModelBase.Word

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