package prod.GiveMeaWord.ModelBase

import com.fasterxml.jackson.annotation.JsonFormat
import org.apache.tomcat.jni.Local
import org.springframework.http.HttpStatus
import java.lang.NumberFormatException
import java.lang.reflect.Executable
import java.time.LocalDateTime
import kotlin.reflect.KClass

class ErrorResponse{
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private val timestamp = java.time.LocalDateTime.now()
    var status:Int = 400
    var msg:String = "Something going wrong! Please give a report."
    var debugMsg: Throwable? = null

    constructor(clientStatus: HttpStatus){status = clientStatus.value()}
    constructor(clientStatus: HttpStatus, clientMsg:String){
        status = clientStatus.value()
        msg = clientMsg
    }
    constructor(clientStatus:HttpStatus, clientMsg:String, clientDebug:Throwable){
        status = clientStatus.value()
        msg = clientMsg
        debugMsg = clientDebug
    }


}