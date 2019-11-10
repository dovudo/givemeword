package prod.GiveMeaWord.api

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import org.springframework.http.HttpStatus
import org.springframework.http.converter.json.GsonHttpMessageConverter
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import prod.GiveMeaWord.ModelBase.ErrorResponse
import prod.GiveMeaWord.Service.WordsService
import java.util.*

@RestController
@RequestMapping("word")
class WordsController(private val service: WordsService) {

    //should be removed
    @GetMapping("id/{id}")
    fun getWordByIndex(@PathVariable("id") id: String) = service.getById(id.toInt()).word

    @GetMapping("/one")
    fun getRandomWord():String{
        val size = service.getSize()
        val rnd = Random()
        return service.getById((rnd.nextInt(size))).word
    }

    @GetMapping("byLength/{l}")
    fun getWordByLength(@PathVariable("l") length:String) = service.getByLength(length.toInt())

    @GetMapping("{size}")
    fun getCollectionBySize(@PathVariable("size")size: String) = service.getCollectionWordsBySize(size.toInt())

    @GetMapping("/size")
    fun getSizeOfWordsList():String = service.getSize().toString()

    @GetMapping("/delete")
    fun deleteAll():String = service.deleteAll()
}