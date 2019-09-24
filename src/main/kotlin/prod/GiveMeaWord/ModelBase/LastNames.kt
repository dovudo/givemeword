package prod.GiveMeaWord.ModelBase

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class LastNames(
        @Id
        @GeneratedValue
        val id:Int,
        val lastName:String
)