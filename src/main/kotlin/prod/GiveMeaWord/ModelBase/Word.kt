package prod.GiveMeaWord.ModelBase

import org.jetbrains.annotations.NotNull
import javax.persistence.*

@Entity
data class Word(
        @Id
        @GeneratedValue(strategy=GenerationType.IDENTITY)
        val id:Int,
        @NotNull
        var word: String,
        @NotNull
        val length: Int
)