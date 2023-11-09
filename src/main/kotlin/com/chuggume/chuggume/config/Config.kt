package com.chuggume.chuggume.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Config {
    val ALL_SPORTS_API_BASE_URI: String = "https://apiv2.allsportsapi.com";

    @Bean
    fun webClient(builder: WebClient.Builder): WebClient =
        builder
            .baseUrl(ALL_SPORTS_API_BASE_URI)
            .codecs { configurer -> configurer.defaultCodecs().maxInMemorySize(2 * 1024 *1024) }
            .build()

}