package prod.GiveMeaWord.Service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.io.File
import java.io.InputStream

@Service
class SeedService {

    @Autowired
    lateinit var personService:PersonService
    @Autowired
    lateinit var wordsService: WordsService

    private val log = LoggerFactory.getLogger("Seed service")
    private val time:Benchmarks = Benchmarks("Seeding class")

    //Paths to seeding files
    private val wordsDirFile = "./src/main/resources/static/google-10000-english-no-swears.txt"
    private val firstNameDirFile = "./src/main/resources/static/first-names.txt"
    private val lastNameDirFile = "./src/main/resources/static/last-names.txt"

    /*
    * Words seeding function
    * Clean the database and seed it from file
    * @return Count of added WORDS
    * For tests benchmark looking and print the time of seeding
    * */
    fun wordSeed(): String {
        val file = wordsDirFile
        //Start benchmark
        time.start("Seeding")
        val stream: InputStream = File(file).inputStream()
        val tmpList = mutableListOf<String>()
        log.info("Cleaning the WORD database")
        wordsService.deleteAll()
        tmpList.addAll(stream.bufferedReader().use { it.readLines() })
        wordsService.addAll(tmpList)
        time.stop()
        log.debug("Seeding Done")
        val addCounter = tmpList.size
        return "Seeding done! \n Added words: $addCounter \n"
    }

    /*
    First name seeding function
    * Clean the database and seed it from file
    * @return Count of added FIRST NAMES
    * For tests benchmark looking and print the time of seeding
    * */
    fun firstNameSeed(): String{
        val file = firstNameDirFile
        val stream: InputStream = File(file).inputStream()
        val firstNameList = mutableListOf<String>()
        log.info("Cleaning first name database")
        personService.cleanFirstName()
        firstNameList.addAll(stream.bufferedReader().use { it.readLines() })
        personService.addAllFirstNames(firstNameList)
        return "Was added first names of ${firstNameList.size} \n"
    }

    /*
    * last name seeding function
    * Clean the database and seed it from file
    * @return Count of added LAST NAMES
    * For tests benchmark looking and print the time of seeding
    * */
    fun lastNameSeed(): String{
        val file = lastNameDirFile
        val stream: InputStream = File(file).inputStream()
        val lastNameList = mutableListOf<String>()
        log.info("Cleaning last name database")
        personService.cleanLastName()
        lastNameList.addAll(stream.bufferedReader().use { it.readLines() })
        personService.addAllLastNames(lastNameList)
        return "Was added first names of ${lastNameList.size} \n"
    }
}