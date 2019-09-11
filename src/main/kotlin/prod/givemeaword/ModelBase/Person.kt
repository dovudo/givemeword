package prod.givemeaword.ModelBase

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Person(
        @Id
        @GeneratedValue
        val id: Long,
        val fullName:String,
        val firstName:String,
        val secondName:String
)