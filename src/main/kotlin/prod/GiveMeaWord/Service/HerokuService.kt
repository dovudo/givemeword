package prod.GiveMeaWord.Service

import io.github.rybalkinsd.kohttp.dsl.httpGet
import java.lang.Thread.sleep


class HerokuService{


    private var wait: Long = 480000
    private var isWorking = true

    fun wakeUp() {
            while (isWorking) {
                sleep(wait)
                 httpGet {
                    host = "localhost"
                     //TODO change that port
                     port = 8080
                     path = "/ip"
                 }
            }
    }

    fun stop() {isWorking = false}
}