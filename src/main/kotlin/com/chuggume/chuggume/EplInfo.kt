package com.chuggume.chuggume

import jakarta.persistence.Embeddable

@Embeddable
data class EplInfo(
    val countryKey: Int?,
    val countryName: String?,
    val countryIso2: String?,
    val countryLogo: String?
)