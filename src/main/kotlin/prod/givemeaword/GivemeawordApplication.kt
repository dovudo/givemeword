package prod.givemeaword

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import prod.givemeaword.Service.SeedService

@SpringBootApplication
class GivemeawordApplication

val SEED_SERVICE: SeedService = SeedService()

fun main(args: Array<String>) {
    runApplication<GivemeawordApplication>(*args)
    }


