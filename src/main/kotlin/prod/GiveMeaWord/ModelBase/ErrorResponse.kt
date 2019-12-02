package prod.GiveMeaWord.ModelBase

import com.fasterxml.jackson.annotation.JsonFormat
import org.springframework.http.HttpStatus

class ErrorResponse {
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    private val timestamp = java.time.LocalDateTime.now()
    private var status: Int = 400
    private var msg: String = "Something going wrong! Please give a report."
    private var debugMsg: Throwable? = null

    constructor(clientStatus: HttpStatus) {
        status = clientStatus.value()
    }

    constructor(clientStatus: HttpStatus, clientMsg: String) {
        status = clientStatus.value()
        msg = clientMsg
    }

    constructor(clientStatus: HttpStatus, clientMsg: String, clientDebug: Throwable) {
        status = clientStatus.value()
        msg = clientMsg
        debugMsg = clientDebug
    }
}