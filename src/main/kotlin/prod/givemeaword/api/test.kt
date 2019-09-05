package prod.givemeaword.api

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.wordsService
import java.io.File

@RestController
class TestApi(private val service: wordsService){

    private val log = LoggerFactory.getLogger("Service")

    @GetMapping("/test")
    fun getMessage(): String {
        return "Fuck you testing"
    }

    @GetMapping("/seed")
    fun seed() :String{
        val file = "./words_alpha.txt"
        var addCounter = 0
        var passCounter = 0
        val bufferReader = File(file).bufferedReader()
        log.info("Seeding started")
        bufferReader.useLines { lines -> lines.forEach {
            if(service.add(it))
                addCounter++
        else
        passCounter++
        }}
        log.debug("Done")
        log.info(addCounter.toString() + "\n" + passCounter.toString())
        return "Seeding done! \n Added words: $addCounter \n Passed words: $passCounter"
    }
    @GetMapping("/size")
    fun getSizeOfList():String = "Size of list is " + getSizeOfList()
}