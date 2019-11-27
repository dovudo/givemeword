package prod.GiveMeaWord

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import prod.GiveMeaWord.Service.TelegramService
import java.net.URL

@RunWith(SpringRunner::class)
@SpringBootTest
class GivemeawordApplicationTests  {

    @Test
    fun printTest(){
        print("Test")
    }

    //Check internet
    @Test
    fun sendToUserTest() {
        URL("https://google.com").readText()
    }

    //Check sending function to Telegram bot
    @Test
    fun sendToUserThroughKOHttpToTelegramBot(){
        val result = TelegramService().sendText("Doing a test")
        assert(result.isSuccessful)
    }
}

class TestAnotherFunctions {

/*
    @Autowired
    private lateinit var service:WordsService

    @Test
    fun addingWordTest() {
        val testWord = "BEorNotToBE"
        service.add(testWord)
        assert(service.checkExistWord(testWord))
    }*/

}
