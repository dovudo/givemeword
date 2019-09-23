package prod.givemeaword.api

import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.*
import java.io.File
import java.io.InputStream

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
