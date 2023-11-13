package com.chuggume.chuggume

import com.fasterxml.jackson.annotation.JsonProperty

data class EplInfoResponse(
    @JsonProperty("result")
    var result: List<Result>
)

data class Result(
    @JsonProperty("country_key")
    val countryKey: Int = 0,

    @JsonProperty("country_name")
    val countryName: String,

    @JsonProperty("country_iso2")
    val countryIso2: String,

    @JsonProperty("country_logo")
    val countryLogo: String
) {
    fun toEplInfo(): EplInfo {
        return EplInfo(
            countryKey = countryKey,
            countryName = countryName,
            countryIso2 = countryIso2,
            countryLogo = countryLogo
        )
    }
}