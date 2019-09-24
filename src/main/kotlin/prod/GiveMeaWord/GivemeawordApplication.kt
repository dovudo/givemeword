package prod.GiveMeaWord

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import prod.GiveMeaWord.Service.SeedService

@SpringBootApplication
class GivemeawordApplication

val SEED_SERVICE: SeedService = SeedService()

fun main(args: Array<String>) {
    runApplication<GivemeawordApplication>(*args)
    }


