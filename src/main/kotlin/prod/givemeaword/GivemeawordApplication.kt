package prod.givemeaword

import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import prod.givemeaword.Service.wordsService
import java.io.File

@SpringBootApplication
class GivemeawordApplication {

    private val log = LoggerFactory.getLogger("Service")

    /*@Bean
    fun init(service:wordsService) =CommandLineRunner {
        val bufferReader = File(file).bufferedReader()
        bufferReader.useLines { lines -> lines.forEach {
            println(it)
            service.add(it) } }
        log.debug("Done")
    }*/

}
fun main(args: Array<String>) {
    runApplication<GivemeawordApplication>(*args)
}
