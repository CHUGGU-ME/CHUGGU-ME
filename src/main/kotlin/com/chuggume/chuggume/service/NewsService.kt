package com.chuggume.chuggume.service

import com.microsoft.playwright.Browser
import com.microsoft.playwright.BrowserType
import com.microsoft.playwright.Page
import com.microsoft.playwright.Playwright
import com.microsoft.playwright.options.LoadState

class NewsService(
    val page: Page,
) {
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

        while(true) {
            println("Enter the number of the article: ")
            val input = readLine()
            if (input == "end") {
                break
            }
            getNewsSelect(input?.toIntOrNull())
        }
    }

    private fun getNewsSelect(no: Int?) {
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
        } else {
            println("Wrong Input, please try again between 1 to 10")
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