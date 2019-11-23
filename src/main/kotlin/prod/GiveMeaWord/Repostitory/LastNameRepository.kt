package prod.GiveMeaWord.Repostitory

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import prod.GiveMeaWord.ModelBase.LastNames

@Repository
interface LastNameRepository: CrudRepository<LastNames,Int> {

    fun save(name:LastNames)
    fun getOneById(id:Int):LastNames

}