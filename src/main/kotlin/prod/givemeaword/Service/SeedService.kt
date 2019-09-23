package prod.givemeaword.Service

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.bind.annotation.GetMapping
import prod.givemeaword.api.TestController
import java.io.File
import java.io.InputStream

@Service
class SeedService {

    @Autowired
    lateinit var personService:PersonService
    @Autowired
    lateinit var wordsService: WordsService
    private val log = LoggerFactory.getLogger("Service")
    private val time:Benchmarks = Benchmarks("Seeding class")


    fun wordSeed(): String {
        val file = "./google-10000-english-no-swears.txt"
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
        return "Seeding done! \n Added words: $addCounter "
    }

    fun firstNameSeed(): String{
        val file = "./first-names.txt"
        val stream: InputStream = File(file).inputStream()
        val firstNameList = mutableListOf<String>()
        log.info("Cleaning first name database")
        personService.cleanFirstName()
        firstNameList.addAll(stream.bufferedReader().use { it.readLines() })
        personService.addAllFirstNames(firstNameList)
        return """Was added first names of ${firstNameList.size}"""
    }

    fun lastNameSeed(): String{
        val file = "./last-names.txt"
        val stream: InputStream = File(file).inputStream()
        val lastNameList = mutableListOf<String>()
        log.info("Cleaning last name database")
        personService.cleanLastName()
        stream.bufferedReader().forEachLine { s -> lastNameList.add(s.toLowerCase())}
        personService.addAllLastNames(lastNameList)
        return """Was added first names of ${lastNameList.size}"""
    }
}