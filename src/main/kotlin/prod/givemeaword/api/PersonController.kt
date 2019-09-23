package prod.givemeaword.api

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import prod.givemeaword.ModelBase.LastNames
import prod.givemeaword.ModelBase.Persons
import prod.givemeaword.Repostitory.LastNameRepository
import prod.givemeaword.Service.PersonService

@RestController("person")
class PersonController(private val service:PersonService) {

    @Autowired
    lateinit var lastNamesRepository: LastNameRepository

    @GetMapping("OneFirstName")
    fun getOneFirstName():String{
        return service.getOneFirstName()
    }

    @GetMapping("OneLastName")
    fun getOneLastName():String{
        return service.getOneLastName()
    }

    @GetMapping("onePerson")
    fun getOnePerson():Persons{
        return service.getOnePerson()
    }

    @GetMapping("getLastById/{id}")
    fun getOneLastById(@PathVariable("id") id:String): LastNames {
        return lastNamesRepository.getOneById(id.toInt())
    }
}