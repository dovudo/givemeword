package prod.GiveMeaWord

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import prod.GiveMeaWord.Service.SeedService
import java.lang.Thread.sleep

@SpringBootApplication
class GivemeawordApplication

fun main(args: Array<String>) {
    runApplication<GivemeawordApplication>(*args)
    }


@Component
class MRunner: CommandLineRunner{

    /*
    Auto seeding on run
    * */
    @Autowired
    lateinit var seed: SeedService
    override fun run(args: Array<String>){
        seed.firstNameSeed()
        seed.lastNameSeed()
        seed.wordSeed()
    }
}