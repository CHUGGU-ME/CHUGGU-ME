package com.chuggume.chuggume.config

import com.microsoft.playwright.*
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

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
                .setHeadless(false)
        )

    @Bean
    fun browserContext(browser: Browser): BrowserContext = browser.newContext()

    @Bean
    fun page(browserContext: BrowserContext): Page = browserContext.newPage()

}