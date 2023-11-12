package com.chuggume.chuggume.service

import com.microsoft.playwright.*
import com.microsoft.playwright.options.LoadState
import org.springframework.stereotype.Service


@Service
class PlayerService(
    val page: Page,
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

    fun news() {
        page.navigate("https://www.premierleague.com/news")
        page.waitForLoadState(LoadState.NETWORKIDLE)

        val newsList = page.querySelectorAll("#mainContent > section > div.wrapper.col-12 > ul > li ")

        var num = 1
        for (news in newsList) {
            val title = news.querySelector(".media-thumbnail__title").innerText()
            println("Article No.${num} ${title}")
            num += 1
        }
        /*
            for (i in 1..10) {
                val querySelector = page.querySelector("#mainContent > section > div.wrapper.col-12 > ul > li:nth-child($i) > a > div > span.media-thumbnail__title").innerText()
                println(querySelector)
            }
        */
    }

    fun newsSelect() {
        page.navigate("https://www.premierleague.com/news")
        page.waitForLoadState(LoadState.NETWORKIDLE)

        getNewsSelect()
    }

    private fun getNewsSelect() {
        println("Enter the number of the article: ")
        val readNo = readLine()
        val no = readNo?.toIntOrNull()
        if (no != null && no <= 10 && no > 0) {
            fun newBrowser(playwright: Playwright): Browser = playwright
                    .chromium()
                    .launch(
                            BrowserType
                                    .LaunchOptions()
                                    .setHeadless(false)
                    )

            val newPage = newBrowser(Playwright.create()).newContext().newPage()
            var url = page.querySelector("#mainContent > section > div.wrapper.col-12 > ul > li:nth-child($no) > a").getAttribute("href")

            if (no != 1) {
                url = url.replace("//", "https:")
            }
            newPage.navigate(url)
            getNewsSelect()
        } else {
            println("The article doesn't exit")
            getNewsSelect()
        }
    }

    fun goal() {
        printlnGoal()
    }

    private fun printlnGoal() {
        val gLetter = arrayOf(
                "  GGGG     OOOO        A      L         !!     !!  ",
                " G    G   O    O      A A     L        !!!!   !!!! ",
                " G       O      O    A   A    L        !!!!    !!  ",
                " G  GGG  O      O   AAAAAAA   L         !!     !!  ",
                " G    G   O    O   A       A  L                    ",
                "  GGGG     OOOO    A       A  LLLLLLL   !!     !!  ",
        )
        for (line in gLetter) {
            println(line)
        }
    }
}