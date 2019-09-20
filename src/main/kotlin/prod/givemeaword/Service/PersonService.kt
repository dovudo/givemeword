package prod.givemeaword.Service

import org.springframework.stereotype.Service
import prod.givemeaword.ModelBase.FirstNames
import prod.givemeaword.ModelBase.LastNames
import prod.givemeaword.Repostitory.FirstNameRepository
import prod.givemeaword.Repostitory.LastNameRepository
import java.util.*
import kotlin.collections.ArrayList

@Service
class PersonService(private val firstNameRepository: FirstNameRepository, private val lastNameRepository: LastNameRepository) {

    private val time:Benchmarks = Benchmarks("Service")

    fun addAllFirstNames(names: List<String>){
        time.start("Adding all first names")
        val array: ArrayList<FirstNames> = ArrayList()
        names.map { str -> array.add(FirstNames(-1, str)) }
        firstNameRepository.saveAll(array)
        time.stop()
    }

    fun getOneFirstName():String{
        val rnd: Random = Random()
        val count = firstNameRepository.count().toInt()
        return firstNameRepository.getOneById(rnd.nextInt(count) + 1).firstName
    }

    fun addAllLastNames(names: List<String>){
        time.start("Adding all last names")
        val array: ArrayList<LastNames> = ArrayList()
        names.map { str -> array.add(LastNames(-1, str)) }
        lastNameRepository.saveAll(array)
        time.stop()
    }

    fun getOneLastName():String{
        val rnd: Random = Random()
        val count = lastNameRepository.count().toInt()
        return lastNameRepository.getOneById(rnd.nextInt(count) + 1).lastName
    }

}