package prod.GiveMeaWord.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import prod.GiveMeaWord.ModelBase.FirstNames
import prod.GiveMeaWord.ModelBase.LastNames
import prod.GiveMeaWord.ModelBase.Persons
import prod.GiveMeaWord.Repostitory.FirstNameRepository
import prod.GiveMeaWord.Repostitory.LastNameRepository
import prod.GiveMeaWord.Service.PersonService

@RestController
@RequestMapping("person")
class PersonController(private val service:PersonService) {

/*
    @Autowired
    lateinit var lastNamesRepository: LastNameRepository
    @Autowired
    lateinit var firstNameRepository: FirstNameRepository
*/

    @GetMapping("/firstname")
    fun getOneFirstName():String = service.getOneFirstName()

    @GetMapping("/lastname")
    fun getOneLastName():String = service.getOneLastName()

    @GetMapping("/one")
    fun getOnePerson():Persons = service.getOnePerson()

    @GetMapping("{size}")
    fun getPersonsList(@PathVariable size:String):List<Persons> = service.getPersonsList(size.toInt())

  /*  @GetMapping("getLastById/{id}")
    fun getOneLastById(@PathVariable("id") id:String): LastNames {
        return lastNamesRepository.getOneById(id.toInt())
    }

    @GetMapping("getFirstById/{id}")
    fun getOneFirstById(@PathVariable("id") id:String): FirstNames {
        return firstNameRepository.getOneById(id.toInt())
    }*/
}