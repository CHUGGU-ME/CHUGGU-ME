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
    private val momService: MomService
) : CommandLineRunner{
    private val log = logger()

    override fun run(vararg args: String?) {
        log.info("hello world!")
        menuGateWay(args)
        log.info("hello world!")
    }

    fun menuGateWay(args: Array<out String?> ){
        when(args[0]){
            "player" -> playerService.service()
            "mom" -> momService.service()
        }
    }
}

fun main(args: Array<String>) {
    SpringApplication.run(ChugguMeApplication::class.java, *args)
}
