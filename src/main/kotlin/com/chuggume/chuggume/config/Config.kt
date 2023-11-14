package com.chuggume.chuggume.config

import com.microsoft.playwright.*

class Config {
    companion object{
        val playwright: Playwright = Playwright.create()
        val browser: Browser = playwright
            .chromium()
            .launch(
                BrowserType
                    .LaunchOptions()
                    .setHeadless(false)
            )
        val browserContext: BrowserContext = browser.newContext()
        val page: Page = browserContext.newPage()
    }

}