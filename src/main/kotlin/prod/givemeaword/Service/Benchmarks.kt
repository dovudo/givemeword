package prod.givemeaword.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

class Benchmark(name: String) {
    private val log: Logger = LoggerFactory.getLogger("Benchmark")
    private var startTime:Long = 0
    private var className:String = name
    private var descriptionTest:String = "Somewhere"

    fun start(description:String) {
        descriptionTest = description
        startTime = System.currentTimeMillis() }
    fun stop() {
        log.warn("$descriptionTest done while: " + (System.currentTimeMillis() - startTime).toString()+ "ms")}
}