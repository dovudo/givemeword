package prod.GiveMeaWord.Service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import prod.GiveMeaWord.ModelBase.Word
import prod.GiveMeaWord.Repostitory.WordsRepository
import java.util.*
import kotlin.collections.ArrayList

@Service
class WordsService(private val repository: WordsRepository) {

    private val time: Benchmarks = Benchmarks("Service")
    private val log = LoggerFactory.getLogger("Word")

    /*
    Adding one word function to database
    @param String of new word
  * @return true if word was added
  * @return false if word was passed
  * */
    fun add(word: String): Boolean {
        time.start("Just add fun")
        return if (!checkExistWord(word)) {
            repository.save(Word(-1, word, word.length))
            time.stop()
            true
        } else {
            time.stop()
            false
        }
    }

    /*
    * Getting list of words by word length
    * Give all words which would found
    * @param Int of words length
    * @return List of found words by length
    *  */
    fun getByLength(length: Int): List<String> {
        val list: ArrayList<String> = ArrayList()
        repository.findByLength(length).map { list.add(it.word) }
        return list
    }

    /*
    * Function for seeding
    * Add all words in one transaction
    * @param List of words
    * */
    fun addAll(words: List<String>) {
        time.start("Add all fun")
        val array: ArrayList<Word> = ArrayList()
        words.map { str -> array.add(Word(-1, str, str.length)) }
        repository.saveAll(array)
        time.stop()
    }

    /*
    * Getting sized list of random worlds
    * @param size of list
    * @return List of random words
    * */
    fun getCollectionWordsBySize(sizeOfList: Int): List<String> {
        val sizeOfBase = getSize()
        val rnd = Random()
        val list = ArrayList<String>()
        for (i in 0 until sizeOfList) {
            list.add(getById((rnd.nextInt(sizeOfBase) + 1)).word)
        }
        return list
    }

    /*
    * Support functions
    * */
    fun getAll(id: Int) = repository.getAllByIdAfter(id)

    fun getById(id: Int) = run { repository.findOneById(id) }
    fun checkExistWord(word: String): Boolean = repository.existsWordByWord(word)
    fun getSize(): Int = repository.count().toInt()
    fun deleteAll(): String {
        val count = getSize()
        repository.deleteAll()
        return "$count entity was removed"
    }
}