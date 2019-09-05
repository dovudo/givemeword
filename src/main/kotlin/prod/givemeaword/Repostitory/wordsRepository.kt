package prod.givemeaword.Repostitory

import org.springframework.data.couchbase.repository.ReactiveCouchbaseRepository
import prod.givemeaword.ModelBase.Word

interface wordsRepository: ReactiveCouchbaseRepository<Word, Long> {

    fun save(wordsMoldel: Word)
    fun findByLength(length:Int):Iterable<Word>
    fun existsWordByWord(word:String):Boolean
    fun getAllByIdAfter(id: Long):Iterable<Word>
    fun findOneById(id: Long):Word
    fun saveAll(words:Iterable<Word>)
}