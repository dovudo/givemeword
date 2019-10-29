package prod.GiveMeaWord

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import prod.GiveMeaWord.Service.WordsService

@RunWith(SpringRunner::class)
@SpringBootTest
class GivemeawordApplicationTests  {

    @Test
    fun printTest(){
        print("Test")
    }

}


@RunWith(SpringRunner::class)
@SpringBootTest
class TestDAO {

    @Autowired
    private lateinit var service:WordsService

    @Test
    fun addingWordTest() {
        val testWord = "BEorNotToBE"
        service.add(testWord)
        assert(service.checkExistWord(testWord))
    }

    @Test
    fun Lera(){
        while(true){
            println("ЛЕРА ПРОСТО КОСМОС")
        }
    }
}
