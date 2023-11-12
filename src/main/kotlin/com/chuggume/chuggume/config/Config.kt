package com.chuggume.chuggume.config

import com.microsoft.playwright.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.web.reactive.function.client.WebClient

@Configuration
class Config {


    @Bean
    fun playWright(): Playwright = Playwright.create()

    @Bean
    fun browser(playwright: Playwright): Browser = playwright
        .chromium()
        .launch(
            BrowserType
                .LaunchOptions()
        )

    @Bean
    fun browserContext(browser: Browser): BrowserContext = browser.newContext()

    @Bean
    fun page(browserContext: BrowserContext): Page = browserContext.newPage()

}