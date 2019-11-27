package prod.GiveMeaWord.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.GiveMeaWord.Repostitory.LogRepository
import prod.GiveMeaWord.Service.SeedService
import java.io.File
import javax.servlet.http.HttpServletRequest

@RestController
class TestController(private val seed: SeedService, private val logRepository: LogRepository) {

    @GetMapping("/test")
    fun getMessage() = "Server is up"

    @GetMapping("/words/seed")
    fun wordSeed() = seed.wordSeed()

    @GetMapping("firstName/seed")
    fun firstNameSeed() = seed.firstNameSeed()

    @GetMapping("lastName/seed")
    fun lastNameSeed() = seed.lastNameSeed()

    @GetMapping("/person/seed")
    fun seed(): String {
        var outStr = ""
        outStr += seed.firstNameSeed()
        outStr += seed.lastNameSeed()
        return outStr
    }

    @GetMapping("/hr")
    fun getHumanRights(): String {
        val stream = File("./src/main/resources/static/HumanRights").bufferedReader()
       return stream.readText()
    }

    @GetMapping("/test/ip")
    fun getIpList(servlet: HttpServletRequest) = logRepository.findAll()
}
