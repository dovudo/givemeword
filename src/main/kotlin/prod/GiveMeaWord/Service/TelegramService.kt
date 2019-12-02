package prod.GiveMeaWord.Service

import io.github.rybalkinsd.kohttp.dsl.httpPost
import okhttp3.Response
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Configuration

@Configuration
class TelegramService {

    @Value("\${telegramBotId}")
    lateinit var telegramToken: String
    @Value("\${telegramChatId}")
    lateinit var chatId: String

    fun sendText(textToSend: String): Response {
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