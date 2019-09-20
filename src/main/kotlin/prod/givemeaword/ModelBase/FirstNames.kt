package prod.givemeaword.ModelBase

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
data class FirstNames(
        @Id
        @GeneratedValue
        val id:Int,
        val firstName:String
)