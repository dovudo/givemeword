package prod.GiveMeaWord.Service

import org.slf4j.LoggerFactory
import org.springframework.stereotype.Component
import org.springframework.web.servlet.HandlerInterceptor
import org.springframework.web.servlet.ModelAndView
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter
import prod.GiveMeaWord.ModelBase.LogModel
import prod.GiveMeaWord.Repostitory.LogRepository
import java.lang.Exception
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class Interceptor(private val logRepository:LogRepository): HandlerInterceptorAdapter() {

    val log = LoggerFactory.getLogger(this::class.java)

    override fun afterCompletion(request: HttpServletRequest, response: HttpServletResponse, handler: Any, ex: Exception?) {
        log.warn("User: ${request.getHeader("User-Agent")} \n Address: ${request.remoteAddr}")
        logRepository.save(LogModel(-1, request.remoteAddr, request.getHeader("User-Agent")))
        super.afterCompletion(request, response, handler, ex)
    }

}