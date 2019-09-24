package prod.GiveMeaWord.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.GiveMeaWord.Service.*

@RestController
class TestController(private val seed:SeedService) {

    @GetMapping("/test")
    fun getMessage() = "Server is up"

    @GetMapping("/words/seed")
    fun wordSeed() = seed.wordSeed()

    @GetMapping("firstName/seed")
    fun firstNameSeed() = seed.firstNameSeed()

    @GetMapping("lastName/seed")
    fun lastNameSeed() = seed.lastNameSeed()

    @GetMapping("/person/seed")
    fun seed(){
        seed.firstNameSeed()
        seed.lastNameSeed()
    }
}
