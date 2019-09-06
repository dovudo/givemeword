package prod.givemeaword.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class TimeMath {
    private val log: Logger = LoggerFactory.getLogger("TimeMath")
    private var startTime:Long = 0
    var count:Int = 0
    fun start() = run { startTime = System.currentTimeMillis()
                        count++ }
    fun stop() {
        if((count % 100) == 0 ) log.warn("Function done while: " + (System.currentTimeMillis() - startTime).toString()+ "ms")}
}