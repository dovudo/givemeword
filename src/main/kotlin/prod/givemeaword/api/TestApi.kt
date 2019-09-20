package prod.givemeaword.api

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.*
import java.io.File
import java.io.InputStream

@RestController
class TestApi(private val wordService: WordsService, private val personService: PersonService) {

    private val log = LoggerFactory.getLogger("Service")
    private val time:Benchmarks = Benchmarks("Seeding class")

    @GetMapping("/test")
    fun getMessage(): String {
        return "Fuck you testing"
    }

    @GetMapping("/words/seed")
    fun seed(): String {
        val file = "./google-10000-english-no-swears.txt"
        //Start benchmark
        time.start("Seeding")
        val stream: InputStream = File(file).inputStream()
        val tmpList = mutableListOf<String>()
        tmpList.addAll(stream.bufferedReader().use { it.readLines() })
        wordService.addAll(tmpList)
        time.stop()
        log.debug("Seeding Done")
        val addCounter = tmpList.size
        return "Seeding done! \n Added words: $addCounter "
    }

    @GetMapping("firstName/seed")
    fun firstNameSeed(): String{

        val file = "./first-names.txt"
        val stream: InputStream = File(file).inputStream()
        val firstNameList = mutableListOf<String>()
        firstNameList.addAll(stream.bufferedReader().use { it.readLines() })
        personService.addAllFirstNames(firstNameList)
        return """Was added first names of ${firstNameList.size}"""
    }

    @GetMapping("lastName/seed")
    fun lastNameSeed(): String{

        val file = "./last-names.txt"
        val stream: InputStream = File(file).inputStream()
        val lastNameList = mutableListOf<String>()
        lastNameList.addAll(stream.bufferedReader().use { it.readLines() })
        personService.addAllLastNames(lastNameList)
        return """Was added first names of ${lastNameList.size}"""
    }
}
