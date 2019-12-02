package prod.GiveMeaWord.Service

import io.github.rybalkinsd.kohttp.dsl.httpGet
import java.lang.Thread.sleep


class HerokuService {

    private var waitTime: Long = 480000
    private var isWorking = true

    fun wakeUp() {
        while (isWorking) {
            println("Hey, wake up now!")
            sleep(waitTime)
            httpGet {
                host = "localhost"
                port = 80
                path = "/test/ip"
            }
        }
    }

    fun stop() {
        isWorking = false
    }
}