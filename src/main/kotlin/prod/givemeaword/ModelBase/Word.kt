package prod.givemeaword.ModelBase

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
@Table(name = "words", schema = "public")
data class Word(
        @Id
        @GeneratedValue
        val id:Long,
        @NotNull
        var word: String,
        @NotNull
        val length: Int
)