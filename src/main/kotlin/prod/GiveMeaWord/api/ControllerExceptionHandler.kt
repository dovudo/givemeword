package prod.GiveMeaWord.api

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import prod.GiveMeaWord.ModelBase.ErrorResponse
import java.time.LocalDateTime

@ControllerAdvice
@ResponseBody
class ControllerExceptionHandler: ResponseEntityExceptionHandler() {

    @ExceptionHandler(NumberFormatException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun NumberFormatExceptionHandler(ex: java.lang.NumberFormatException):ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST,"Check the string on characters",ex)
    }

}