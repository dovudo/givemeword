package prod.GiveMeaWord.Service

import io.github.rybalkinsd.kohttp.dsl.httpPost
import okhttp3.Response
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration
import org.springframework.stereotype.Service

@Configuration
class TelegramService {

    private val log = LoggerFactory.getLogger(this::class.java)
    @Value("\${telegramBotId}")
    lateinit var telegramToken:String
    @Value("\${telegramChatId}")
    lateinit var chatId: String

    fun sendText(textToSend:String):Response {
        httpPost {
            host = "api.telegram.org"
            scheme = "https"
            path = "/bot$telegramToken/sendMessage"

            body {
                json {
                    "chat_id" to chatId
                    "text" to textToSend
                }
            }
        }.use {
            //log.warn("TOKEN: $telegramToken , CHAT: $chatId")
            //log.info("Sending massage to Telegram bot: $it")
            return it
        }
    }
}