package com.chuggume.chuggume.external

import com.chuggume.chuggume.logger
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.context.support.GenericXmlApplicationContext
import org.springframework.core.env.ConfigurableEnvironment
import org.springframework.core.env.MutablePropertySources
import org.springframework.stereotype.Component
import org.springframework.web.reactive.function.client.WebClient


@Component
class AllSportsApiCaller(
    val webClient: WebClient,
) {
    val log = logger()

    val ALL_SPORTS_API_BASE_URI: String = "https://apiv2.allsportsapi.com";
    fun getApiKey(): String {
        var ctx: ConfigurableApplicationContext = GenericXmlApplicationContext()
        var env: ConfigurableEnvironment = ctx.getEnvironment();
        var propertySources: MutablePropertySources = env.getPropertySources()
        return env.getProperty("API_KEY") ?: ""
    }

    fun postCountries(){


    }


}