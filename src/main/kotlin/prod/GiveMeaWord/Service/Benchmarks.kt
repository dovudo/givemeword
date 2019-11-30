package prod.GiveMeaWord.Service

import org.slf4j.Logger
import org.slf4j.LoggerFactory

/*
* Test size
* Special class for count the time
* how much some functions take a time for doing
* @param name of function or class for log
*
*/
class Benchmarks(name: String = "Benchmark") {

    private val log: Logger = LoggerFactory.getLogger(name)
    private var startTime:Long = 0
    private var descriptionTest:String = "Somewhere in code"

    fun start(description:String) {
        descriptionTest = description
        startTime = System.currentTimeMillis() }
    fun stop() {
        log.warn("$descriptionTest done while: " + (System.currentTimeMillis() - startTime).toString()+ "mos")}
}