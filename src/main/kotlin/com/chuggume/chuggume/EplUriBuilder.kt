package com.chuggume.chuggume

import org.springframework.stereotype.Component
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI

@Component
class EplUriBuilder{
    private companion object {
        const val FIRST_EPL_URL = "https://apiv2.allsportsapi.com/football/"
        const val SECOND_EPL_URL = ""
        const val THIRD_EPL_URL = ""
        const val FOURTH_EPL_URL = ""
        const val FIFTH_EPL_URL = ""
        const val SIXTH_EPL_URL = ""
        const val SEVENTH_EPL_URL = ""
        const val EIGHTH_EPL_URL = ""
    }
    private val eplRestApiKey: String = "ecbf45a923a917ba93454ca02650f6991301e00eac27a713a6e4c081ad17fd28"
    fun buildUriByFirstCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(FIRST_EPL_URL)
        uriBuilder.queryParam("met", command)
        uriBuilder.queryParam("APIkey", eplRestApiKey)

        return uriBuilder.build().encode().toUri()
    }

    fun buildUriBySecondCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(SECOND_EPL_URL)
//        uriBuilder.queryParam() //TODO

        return uriBuilder.build().encode().toUri()
    }

    fun buildUriByThirdCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(THIRD_EPL_URL)
//        uriBuilder.queryParam() //TODO

        return uriBuilder.build().encode().toUri()
    }

    fun buildUriByFourthCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(FOURTH_EPL_URL)
//        uriBuilder.queryParam() //TODO

        return uriBuilder.build().encode().toUri()
    }

    fun buildUriByFifthCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(FIFTH_EPL_URL)
//        uriBuilder.queryParam() //TODO

        return uriBuilder.build().encode().toUri()
    }

    fun buildUriBySixthCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(SIXTH_EPL_URL)
//        uriBuilder.queryParam() //TODO

        return uriBuilder.build().encode().toUri()
    }

    fun buildUriBySeventhCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(SEVENTH_EPL_URL)
//        uriBuilder.queryParam() //TODO

        return uriBuilder.build().encode().toUri()
    }

    fun buildUriByEighthCommand(command: String, arg: String?): URI {
        val uriBuilder = UriComponentsBuilder.fromHttpUrl(EIGHTH_EPL_URL)
//        uriBuilder.queryParam() //TODO

        return uriBuilder.build().encode().toUri()
    }
}