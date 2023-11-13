package com.chuggume.chuggume.domain

import com.microsoft.playwright.ElementHandle

data class Player(
    val firstName: String,
    val lastName: String,
    val number: String,
    val club: String,
    val position: String,
    val nationality: String,
    val dateOfBirth: String,
    val height: String,
    val score: String,
    val assist: String,
){
    companion object{
        fun of(playerPageMainContent: ElementHandle): Player{
            return Player(
                firstName = playerPageMainContent.querySelector(".player-header__name-first").innerText(),
                lastName = playerPageMainContent.querySelector(".player-header__name-last").innerText(),
                number = playerPageMainContent.querySelector("section > div.player-header__player-number.player-header__player-number--large").innerText(),
                position = playerPageMainContent.querySelector("div.wrapper.hasFixedSidebar > nav > div > section:nth-child(1) > div:nth-child(3) > div.player-overview__info").innerText(),
                club = playerPageMainContent.querySelector("div.wrapper.hasFixedSidebar > nav > div > section:nth-child(1) > div:nth-child(2) > div.player-overview__info").innerText(),
                nationality = playerPageMainContent.querySelector(".player-info__player-country").innerText(),
                dateOfBirth = playerPageMainContent.querySelector("div.wrapper.hasFixedSidebar > div > div > div.player-info.u-hide-mob > section > div > div:nth-child(2) > div.player-info__info").innerText(),
                height = playerPageMainContent.querySelector("div.wrapper.hasFixedSidebar > div > div > div.player-info.u-hide-mob > section > div > div:nth-child(3) > div.player-info__info").innerText(),
                score = playerPageMainContent.querySelector("div.wrapper.hasFixedSidebar > nav > div > section:nth-child(2) > div > div:nth-child(2) > div.player-overview__info").innerText(),
                assist = playerPageMainContent.querySelector("div.wrapper.hasFixedSidebar > nav > div > section:nth-child(2) > div > div:nth-child(3) > div.player-overview__info").innerText(),
                )
        }
    }

    override fun toString(): String{
        val sb: StringBuilder = StringBuilder()
        sb.append("name: ${firstName} ${lastName}\n")
        sb.append("club: ${club}\n")
        sb.append("position: ${position}\n")
        sb.append("number: ${number}\n")
        sb.append("height: ${height}\n")
        sb.append("date of birth: ${dateOfBirth}\n")
        sb.append("nationality: ${nationality}\n")
        sb.append("score: ${score}\n")
        sb.append("assist: ${assist}\n")
        return sb.toString()
    }
}
