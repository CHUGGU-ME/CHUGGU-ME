package com.chuggume.chuggume.service

import com.chuggume.chuggume.domain.Player
import com.microsoft.playwright.Browser
import com.microsoft.playwright.ElementHandle
import com.microsoft.playwright.Page
import com.microsoft.playwright.options.LoadState
import org.springframework.stereotype.Service


@Service
class PlayerService(
    val page: Page,
) {

    fun looadPlayersPage() {
        page.navigate("https://www.premierleague.com/players")
        page.waitForLoadState(LoadState.LOAD)
        if (page.querySelector("#onetrust-banner-sdk > div").isVisible) {
            page.querySelector("#onetrust-accept-btn-handler").click()
        }
        page.waitForLoadState(LoadState.NETWORKIDLE)
    }

    fun service(args: Array<out String?>) {
        looadPlayersPage()

        page.querySelector("#search-input").fill(args[1])
        page.querySelector("#mainContent > div.playerIndex > header > div > div > div > div")
            .click()
        page.waitForTimeout(1000.0)
        page.querySelector(".player").querySelector(".player__name").click()
        page.waitForLoadState()

        var playerPage: ElementHandle = page.querySelector("#mainContent")
        println(Player.of(playerPage).toString())
        println(page.url())
    }
}