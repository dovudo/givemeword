package prod.givemeaword.Repostitory

import org.springframework.data.repository.CrudRepository
import prod.givemeaword.ModelBase.Word

interface wordsRepository: CrudRepository<Word,Long> {

    fun save(wordsMoldel: Word)
    fun findByLength(length:Int):Iterable<Word>
    fun existsWordByWord(word:String):Boolean
    fun getAllByIdAfter(id: Long):Iterable<Word>
    fun findOneById(id: Long):Word
}