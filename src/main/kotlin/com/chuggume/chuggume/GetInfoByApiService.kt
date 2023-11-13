package com.chuggume.chuggume

import io.github.resilience4j.circuitbreaker.CallNotPermittedException
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker
import org.springframework.stereotype.Service
import mu.KotlinLogging.logger

@Service
class GetInfoByApiService(
    private val eplApiManager: EplApiManager
) {
    val logger = logger {}

    @CircuitBreaker(name = "", fallbackMethod = "fallbackGetEplInfo")
    fun getEplInfo(command: String,
                   arg: String?): EplInfoResponse {
//        val command = "Countries"
        val response = eplApiManager.requestEplInfo(command, arg)
        checkNotNull(response) { "api 호출 오류" }
        return response
    }

    fun fallbackGetEplInfo(t: CallNotPermittedException): String {
        logger.error("CircuitBreaker OPEN: " + t.message)
        return "Fallback function is called!"
    }
}