package prod.GiveMeaWord.Repostitory

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import prod.GiveMeaWord.ModelBase.LogModel

@Repository
interface LogRepository : CrudRepository<LogModel,Int>{
    fun save(log:LogModel)
    override fun findAll(): List<LogModel>

}