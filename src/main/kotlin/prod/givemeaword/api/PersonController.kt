package prod.givemeaword.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.Service.FirstNameService
import prod.givemeaword.Service.PersonService

@RestController("person")
class PersonController(private val service:PersonService) {

    @GetMapping("OneFirstName")
    fun getOneFirstName():String{
        return service.getOneFirstName()
    }

    @GetMapping("OneLastName")
    fun getOneLastName():String{
        return service.getOneLastName()
    }
}