package prod.GiveMeaWord

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Component
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import prod.GiveMeaWord.Service.HerokuService
import prod.GiveMeaWord.Service.Interceptor
import prod.GiveMeaWord.Service.SeedService

@SpringBootApplication
class GivemeawordApplication

fun main(args: Array<String>) {
    runApplication<GivemeawordApplication>(*args)
}


@Component
class MRunnerAndConfigurer : CommandLineRunner, WebMvcConfigurer {
    @Autowired
    lateinit var seed: SeedService
    @Autowired
    lateinit var myInterceptor: Interceptor

    //Seeding and start self wakeup
    override fun run(args: Array<String>) {
        //seed.firstNameSeed()
        //seed.lastNameSeed()
        //seed.wordSeed()
        GlobalScope.launch {
            HerokuService().wakeUp()
        }
    }

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(myInterceptor)
    }
}
