package prod.GiveMeaWord.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import prod.GiveMeaWord.Service.WordsService
import java.util.*

@RestController
class WordsController(private val service: WordsService) {

    //should be removed
    @GetMapping("/word/id/{id}")
    fun getWordByIndex(@PathVariable("id") id: String): String {
        id.toIntOrNull()?.let {
            return service.getById(it).word
        }
        return "Invalid Id"
    }

    @GetMapping("/word")
    fun getRandomWord():String{
        val size = service.getSize()
        val rnd = Random()
        return service.getById((rnd.nextInt(size))).word
    }

    @GetMapping("/words/length/{l}")
    fun getWordByLength(@PathVariable("l") length:String): List<String>{
        return service.getByLength(length.toInt())
    }

    @GetMapping("/words/{size}")
    fun getCollectionBySize(@PathVariable("size")size: Int):List<String>{
        return service.getCollectionWordsBySize(size)
    }

    @GetMapping("/size")
    fun getSizeOfWordsList():String = service.getSize().toString()

    @GetMapping("/delete")
    fun deleteAll():String = service.deleteAll()
}