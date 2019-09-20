package prod.givemeaword.Service

import org.springframework.stereotype.Service
import prod.givemeaword.ModelBase.FirstNames
import prod.givemeaword.ModelBase.LastNames
import prod.givemeaword.Repostitory.LastNameRepository
import java.util.*
import kotlin.collections.ArrayList

@Service
class LastNameService(private val repository:LastNameRepository) {

    private val time:Benchmarks = Benchmarks("Service")

    fun addAllLastNames(names: List<String>){
        time.start("Adding all first names")
        val array: ArrayList<LastNames> = ArrayList()
        names.map { str -> array.add(LastNames(-1, str)) }
        repository.saveAll(array)
        time.stop()
    }

    fun getOneLastName():String{
        val rnd: Random = Random()
        val count = repository.count().toInt()
        return repository.getOneById(rnd.nextInt(count) + 1).lastName
    }

}