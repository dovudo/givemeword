package prod.GiveMeaWord.Service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import prod.GiveMeaWord.ModelBase.LogModel
import prod.GiveMeaWord.Repostitory.LogRepository
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class Interceptor(private val logRepository:LogRepository, private val telegramService: TelegramService): HandlerInterceptorAdapter() {

    val log = LoggerFactory.getLogger(this::class.java)

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {

        /*
        Ignore that route for wakeup function
        And does't write every request while getting ip list
         */
        if(request.requestURI == "/test/ip")
            return

        val userInfo = "User: ${request.getHeader("User-Agent")} \n Address: ${request.remoteAddr} \n Path: ${request.requestURI}"
        log.info(userInfo)
        logRepository.save(LogModel(-1, request.remoteAddr, request.getHeader("User-Agent"), request.requestURI))
        //Sending logs to Telegram
        telegramService.sendText(userInfo)
        super.afterCompletion(request, response, handler, ex)
    }
}