package prod.givemeaword.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.wordsService

@RestController
class wordsController(private val service: wordsService) {

    @GetMapping("/word/{id}")
    fun getWordByIndex(@PathVariable("id") id: String): String {
        id.toLongOrNull()?.let {
            return service.getById(it).word
        }
        return "Invalid Id"
    }
    @GetMapping("/word/l/{l}")
    fun getWordByLength(@PathVariable("l") length:String): List<String>{
        return service.getByLength(length.toInt())
    }

    @GetMapping("/words/{index}")
    fun getAllWords(@PathVariable("index")index: String = "0"):String{
        return service.getAll(index.toLong()).toString()
    }

    @GetMapping("/size")
    fun getSize():String =  "Size of list is :" + service.getSize()

}