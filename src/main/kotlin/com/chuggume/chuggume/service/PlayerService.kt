package com.chuggume.chuggume.service

import com.microsoft.playwright.ElementHandle
import com.microsoft.playwright.Page
import org.springframework.stereotype.Service


@Service
class PlayerService(
    val page: Page
) {

    fun service(args: Array<out String?> ){
        page.navigate("https://www.premierleague.com/players")
        if(page.querySelector("#onetrust-banner-sdk > div").isVisible){
            page.querySelector("#onetrust-accept-btn-handler").click()
        }
        page.waitForTimeout(2000.0)
        page.querySelector("#search-input").fill(args[1])
        page.querySelector("#mainContent > div.playerIndex > header > div > div > div > div").click()
        page.waitForTimeout(2000.0)

        var selectPlayer:ElementHandle = page.querySelector(".player")
        println(selectPlayer.querySelector(".player__name").innerText())

    }
}