package prod.GiveMeaWord.Service

import io.github.rybalkinsd.kohttp.dsl.httpPost
import okhttp3.Response
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class TelegramService {

    private val log = LoggerFactory.getLogger(this::class.java)
    private val  telegramToken:String = "\"930792868:AAGZvnBCVgnE0tNQ1MOHw5Fy8UJFQHtmnrI\""
    private val chatId: String = "206498046"

    fun sendText(textToSend:String):Response {
        val req = httpPost {
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
            log.info("Sending massage to Telegram bot: $it")
            return it
        }
    }
}