package prod.givemeaword.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import prod.givemeaword.ModelBase.FirstNames
import prod.givemeaword.ModelBase.LastNames
import prod.givemeaword.ModelBase.Persons
import prod.givemeaword.Repostitory.FirstNameRepository
import prod.givemeaword.Repostitory.LastNameRepository
import java.lang.StringBuilder
import java.util.*
import kotlin.collections.ArrayList

@Service
class PersonService(private val firstNameRepository: FirstNameRepository, private val lastNameRepository: LastNameRepository) {

    private val time:Benchmarks = Benchmarks("Service")
    private val log: Logger = LoggerFactory.getLogger("Person Service")

    fun addAllFirstNames(names: List<String>){
        time.start("Adding all first names")
        val array: ArrayList<FirstNames> = ArrayList()
        names.map { str -> array.add(FirstNames(-1, str)) }
        firstNameRepository.saveAll(array)
        time.stop()
    }

    fun addAllLastNames(names: List<String>){
        time.start("Adding all last names")
        val array: ArrayList<LastNames> = ArrayList()
        names.map { str -> array.add(LastNames(-1, str)) }
        lastNameRepository.saveAll(array)
        time.stop()
    }

    fun getOneFirstName():String{
        val count = firstNameRepository.count().toInt()
        val rnd = Random().nextInt(count)
        log.warn("frist name index: " + rnd.toString())
        return firstNameRepository.getOneById(rnd).firstName
    }

    fun getOneLastName():String{
        val count = lastNameRepository.count().toInt()
        val rnd = Random().nextInt(count)
        log.warn("last name index: " + rnd.toString())
        return lastNameRepository.getOneById(rnd).lastName
    }

    fun getOnePerson():Persons{
        val firstName = getOneFirstName()
        val lastName = getOneLastName()
        val fullName = "$firstName $lastName"
        return Persons(fullName, firstName, lastName)
    }

    fun cleanFirstName() = firstNameRepository.deleteAll()
    fun cleanLastName() = lastNameRepository.deleteAll()
}