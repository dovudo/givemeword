package prod.GiveMeaWord.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.stereotype.Service
import prod.GiveMeaWord.ModelBase.FirstNames
import prod.GiveMeaWord.ModelBase.LastNames
import prod.GiveMeaWord.ModelBase.Persons
import prod.GiveMeaWord.Repostitory.FirstNameRepository
import prod.GiveMeaWord.Repostitory.LastNameRepository
import kotlin.collections.ArrayList
import kotlin.random.Random

@Service
class PersonService(private val firstNameRepository: FirstNameRepository, private val lastNameRepository: LastNameRepository) {

    private val time:Benchmarks = Benchmarks("Service")
    private val log: Logger = LoggerFactory.getLogger("Person Service")

    /*
    * This function adding the List of 'FirstNames' model
    * to database through Crud repository
    * and count the time while it worked
    * */
    fun addAllFirstNames(names: List<String>){
        time.start("Adding all first names")
        val array: ArrayList<FirstNames> = ArrayList()
        names.map { str -> array.add(FirstNames(-1, str)) }
        firstNameRepository.saveAll(array)
        time.stop()
    }

    /*
   * This function adding the List of 'LastNames' model
   * to database through Crud repository
   * and count the time while it worked
   * */
    fun addAllLastNames(names: List<String>){
        time.start("Adding all last names")
        val array: ArrayList<LastNames> = ArrayList()
        names.map { str -> array.add(LastNames(-1, str)) }
        lastNameRepository.saveAll(array)
        time.stop()
    }

    /*
    Getting random first name from data base
    * @return first name: String
    * */
    fun getOneFirstName():String{
        val count = firstNameRepository.count().toInt()
        val rnd:Int = (1..count).random()
        return firstNameRepository.getOneById(rnd).firstName
    }

    /*
    * Getting random last name form database
    * @return last name: String
    * */
    fun getOneLastName():String{
        val count = lastNameRepository.count().toInt()
        val rnd = (1..count).random()
        return lastNameRepository.getOneById(rnd).lastName
    }

    /*
    * Take a random first name, last name
    * spilt it and make a full name
    * create the Person model
    * @return Person model with random first, last names
    * */
    fun getOnePerson():Persons{
        val firstName = getOneFirstName()
        val lastName = getOneLastName()
        val fullName = "$firstName $lastName"
        return Persons(fullName, firstName, lastName)
    }

    /*
    * Give a list of persons
    * by getOnePerson function
    * @param size of list
    * @return list of persons
    * */
    fun getPersonsList(size:Int): List<Persons> {
        val list:ArrayList<Persons> = ArrayList()
        for(i in 0 until size){
            list.add(getOnePerson())
        }
        return list
    }

    /*
    * Support functions for cleaning a databases
    * of first name and last name
    * Used in seed functions
    * */
    fun cleanFirstName() = firstNameRepository.deleteAll()
    fun cleanLastName() = lastNameRepository.deleteAll()
}