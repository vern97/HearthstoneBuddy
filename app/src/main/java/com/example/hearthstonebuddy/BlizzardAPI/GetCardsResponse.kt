package com.example.hearthstonebuddy.BlizzardAPI

import com.example.hearthstonebuddy.BlizzardAPI.Card
import com.google.gson.annotations.SerializedName

data class GetCardsResponse (
    @SerializedName("cardCount")
    val cardCount: Int,
    @SerializedName("cards")
    val cards: List<Card>,
    @SerializedName("page")
    val page: Int,
    @SerializedName("pageCount")
    val pageCount: Int
)

