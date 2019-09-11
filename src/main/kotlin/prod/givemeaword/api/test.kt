package prod.givemeaword.api

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.Benchmark
import prod.givemeaword.Service.WordsService
import java.io.File
import java.io.InputStream

@RestController
class TestApi(private val service: WordsService) {

    private val log = LoggerFactory.getLogger("Service")

    @GetMapping("/test")
    fun getMessage(): String {
        return "Fuck you testing"
    }

    @GetMapping("/seed")
    fun seed(): String {
        val time:Benchmark = Benchmark("Seeding")
        val file = "./google-10000-english-no-swears.txt"
        //Start benchmark
        time.start("Seeding")
        log.info("Seeding started")
        val stream: InputStream = File(file).inputStream()
        val tmpList = mutableListOf<String>()
        tmpList.addAll(stream.bufferedReader().use { it.readLines() })
        service.addAll(tmpList)
        time.stop()
        log.debug("Seeding Done")
        val addCounter = tmpList.size
        return "Seeding done! \n Added words: $addCounter "
    }
}
