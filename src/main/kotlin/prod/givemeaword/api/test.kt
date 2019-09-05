package prod.givemeaword.api

import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.wordsService
import java.io.File
import java.io.InputStream
import java.io.InputStreamReader

@RestController
class TestApi(private val service: wordsService){

    private val log = LoggerFactory.getLogger("Service")

    @GetMapping("/test")
    fun getMessage(): String {
        return "Fuck you testing"
    }

    @GetMapping("/seed")
    fun seed() :String{
        val file = "./google-10000-english-usa.txt"
        var addCounter = 0
        var passCounter = 0
        log.info("Seeding started")
        val myList = mutableListOf<String>()
        File(file).useLines { lines -> myList.addAll(lines) }


      /*  bufferReader.useLines { lines -> lines.forEach {
            if(service.add(it))
                addCounter++
        else
        passCounter++
        }}*/
        log.debug("Done")
        log.info(addCounter.toString() + "\n" + passCounter.toString())
        return "Seeding done! \n Added words: $addCounter \n Passed words: $passCounter"
    }
}