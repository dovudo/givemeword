package prod.GiveMeaWord.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import prod.GiveMeaWord.ModelBase.Persons
import prod.GiveMeaWord.Service.PersonService

@RestController
@RequestMapping("person")
class PersonController(private val service: PersonService) {

    @GetMapping("/firstname")
    fun getOneFirstName(): String = service.getOneFirstName()

    @GetMapping("/lastname")
    fun getOneLastName(): String = service.getOneLastName()

    @GetMapping("/one")
    fun getOnePerson(): Persons = service.getOnePerson()

    @GetMapping("{size}")
    fun getPersonsList(@PathVariable size: String) = service.getPersonsList(size.toInt())

}