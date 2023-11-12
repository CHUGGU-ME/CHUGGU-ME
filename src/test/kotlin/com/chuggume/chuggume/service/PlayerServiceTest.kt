package com.chuggume.chuggume.service

import com.microsoft.playwright.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.junit.jupiter.MockitoExtension


@ExtendWith(MockitoExtension::class)
class PlayerServiceTest{

    val playWright: Playwright= Playwright.create()
    val browser: Browser = playWright
        .chromium()
        .launch(
            BrowserType
                .LaunchOptions()
        )
    val browserContext: BrowserContext = browser.newContext()
    val page: Page = browserContext.newPage()

    @InjectMocks
    val playerService: PlayerService = PlayerService(page)



    @Test
    fun `son 입력`(){
        playerService.service(arrayOf("player","son"))
    }

    @Test
    fun `harry kane 입력`(){
        playerService.service(arrayOf("player","harry kane"))
    }


}