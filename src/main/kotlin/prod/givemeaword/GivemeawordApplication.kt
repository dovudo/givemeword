package prod.givemeaword

import org.slf4j.LoggerFactory
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.runApplication

@SpringBootApplication
class GivemeawordApplication
    fun main(args: Array<String>) {
        runApplication<GivemeawordApplication>(*args)
    }

