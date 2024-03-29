package prod.GiveMeaWord.api

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler
import prod.GiveMeaWord.ModelBase.ErrorResponse

@ControllerAdvice
@ResponseBody
class ControllerExceptionHandler : ResponseEntityExceptionHandler() {

    @ExceptionHandler(NumberFormatException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun numberFormatExceptionHandler(ex: java.lang.NumberFormatException): ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST, "Check the string on characters", ex)
    }

    @ExceptionHandler(Exception::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun anyException(ex: java.lang.Exception): ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST, "Oops \n Something going wrong! \n Send the report to our support center")
    }

    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    fun runTimeException(ex: java.lang.RuntimeException): ErrorResponse {
        return ErrorResponse(HttpStatus.BAD_REQUEST, "Oops \n Something going wrong on runtime! \n Send the report to our support center")

    }
}