package prod.givemeaword.ModelBase

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
data class Word(
        @Id
        @GeneratedValue
        val id:Long,
        var word: String,
        val length: Int
)