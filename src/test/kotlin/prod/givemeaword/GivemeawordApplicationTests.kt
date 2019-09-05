package prod.givemeaword

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import prod.givemeaword.Service.wordsService

@RunWith(SpringRunner::class)
@SpringBootTest
class GivemeawordApplicationTests  {

    @Test
    fun printTest(){
        print("Test")
    }

}

class TestDAO(private val service:wordsService){

    @Test
    fun addingWordTest() {
        val TEST_WORD = "BEorNotToBE"
        service.add(TEST_WORD)
        assert(service.checkExistWord(TEST_WORD))
    }
}
