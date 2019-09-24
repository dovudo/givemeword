package prod.GiveMeaWord.Repostitory

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import prod.GiveMeaWord.ModelBase.FirstNames

@Repository
interface FirstNameRepository: CrudRepository<FirstNames,Int>{
    fun save(name:FirstNames)
    fun getOneById(id:Int):FirstNames
}