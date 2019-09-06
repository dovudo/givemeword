package prod.givemeaword.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.TimeMath
import prod.givemeaword.Service.WordsService
import java.util.*

@RestController
class WordsController(private val service: WordsService) {

    @GetMapping("/word?id={id}")
    fun getWordByIndex(@PathVariable("id") id: String): String {
        id.toLongOrNull()?.let {
            return service.getById(it).word
        }
        return "Invalid Id"
    }
    @GetMapping("/word")
    fun getRandomWord():String{
        val size = service.getSize().toInt()
        val rnd = Random()
        return service.getById((rnd.nextInt(size).toLong())).word
    }

    @GetMapping("/word/length/{l}")
    fun getWordByLength(@PathVariable("l") length:String): List<String>{
        return service.getByLength(length.toInt())
    }

    @GetMapping("/words/{index}")
    fun getAllWords(@PathVariable("index")index: String = "0"):String{
        return service.getAll(index.toLong()).toString()
    }

    @GetMapping("/size")
    fun getSizeOfWordsList():String = service.getSize().toString()
}