package com.chuggume.chuggume

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.client.RestTemplate
import java.net.URI
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.stereotype.Component
import java.lang.reflect.Constructor

@Component
class EplApiManager(
    private val eplUriBuilder: EplUriBuilder,
    @Autowired private val restTemplate: RestTemplate,
) {
    fun requestEplInfo(command: String, arg: String?): EplInfoResponse? {
        checkNotNull(command) { return null }

        val uri: URI = when(command) {
            "first" -> eplUriBuilder.buildUriByFirstCommand(command, arg)
            "second" -> eplUriBuilder.buildUriBySecondCommand(command, arg)
            "third" -> eplUriBuilder.buildUriByThirdCommand(command, arg)
            "fourth" -> eplUriBuilder.buildUriByFourthCommand(command, arg)
            "fifth" -> eplUriBuilder.buildUriByFifthCommand(command, arg)
            "sixth" -> eplUriBuilder.buildUriBySixthCommand(command, arg)
            "seventh" -> eplUriBuilder.buildUriBySeventhCommand(command, arg)
            else -> eplUriBuilder.buildUriByEighthCommand(command, arg)
        }
        val headers = HttpHeaders()
//        headers.set(HttpHeaders.AUTHORIZATION, "EplAK $eplRestApiKey")

        val httpEntity = HttpEntity<String>(headers)

        val response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, EplInfoResponse::class.java).body

        return response
    }
}