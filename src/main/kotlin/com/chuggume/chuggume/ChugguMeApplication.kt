package com.chuggume.chuggume


import com.chuggume.chuggume.service.MomService
import com.chuggume.chuggume.service.PlayerService
import org.slf4j.LoggerFactory
import org.springframework.boot.CommandLineRunner
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

inline fun <reified T> T.logger() = LoggerFactory.getLogger(T::class.java)!!

@SpringBootApplication
class ChugguMeApplication(
    private val playerService: PlayerService,
    private val getInfoByApiService: GetInfoByApiService
    private val momService: MomService

) : CommandLineRunner{
    private val log = logger()

    override fun run(vararg args: String?) {

        menuGateWay(args)
        log.info("hello world!")
//        val command = "Countries"
//        val arg = ""
//        val result = getInfoByApiService.getEplInfo(command, arg)
//        println(result)
    }

    fun menuGateWay(args: Array<out String?> ){
        if(args.size < 1 ) println("no args")
        when(args[0]){
            "player" -> playerService.service(args)
            "goal" -> playerService.goal()
            "news" -> playerService.news()
            "article" -> playerService.newsSelect()
            "mom" -> momService.service()
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ChugguMeApplication::class.java, *args)
}
