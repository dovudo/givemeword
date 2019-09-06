package prod.givemeaword.api

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.TimeMath
import prod.givemeaword.Service.WordsService
import java.io.File
import java.io.InputStream

@RestController
class TestApi(private val service: WordsService) {

    private val log = LoggerFactory.getLogger("Service")
    private val time:TimeMath = TimeMath()
    @GetMapping("/test")
    fun getMessage(): String {
        return "Fuck you testing"
    }

    @GetMapping("/seed")
    fun seed(): String {
        val file = "./google-10000-english-no-swears.txt"
        var addCounter = 0
        var passCounter = 0
        val bufferReader = File(file).bufferedReader()
        log.info("Seeding started")
        time.start()
        val stream: InputStream = File(file).inputStream()
        //val tmpList = mutableListOf<String>()
        //tmpList.addAll(stream.bufferedReader().use { it.readLines()})
        //stream.bufferedReader().lines().forEach { line -> service.add(line) }
        //tmpList.forEach { line -> service.add(line) }
        bufferReader.useLines { lines ->
            lines.forEach {
                passCounter++
                if (service.add(it)) {
                    addCounter++
                    time.stop()
                }

                else
                    time.stop()
            }
        }
        log.debug("Done")
        log.info(addCounter.toString() + "\n" + passCounter.toString())
        return "Seeding done! \n Added words: $addCounter \n Passed words: $passCounter"
    }
}