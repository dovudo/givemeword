package prod.givemeaword.Service

import org.springframework.stereotype.Service
import prod.givemeaword.ModelBase.FirstNames
import prod.givemeaword.Repostitory.FirstNameRepository
import java.util.*
import kotlin.collections.ArrayList

@Service
class FirstNameService(private val repository:FirstNameRepository){

    private val time:Benchmarks = Benchmarks("Service")

    fun addAll(names: List<String>){
        time.start("Adding all first names")
        val array: ArrayList<FirstNames> = ArrayList()
        names.map { str -> array.add(FirstNames(-1, str)) }
        repository.saveAll(array)
        time.stop()
    }

    fun getOneFirstName():String{
        val rnd: Random = Random()
        val count = repository.count().toInt()
        return repository.getOneById(rnd.nextInt(count) + 1).firstName
    }

}