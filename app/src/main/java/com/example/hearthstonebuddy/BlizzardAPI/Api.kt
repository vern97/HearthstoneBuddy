package com.example.hearthstonebuddy.BlizzardAPI

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface Api {
    @GET("hearthstone/cards?locale=en_US&manaCost=0")
    fun getAllCards(
        @Query("access_token") apiKey: String = "US4V254pqZQICK9ejRdem9pMwU7S874bU2",
        @Query("page") page: Int
    ): Call<GetCardsResponse>

    @GET("hearthstone/cards?locale=en_US&manaCost=1")
    fun getOneManaCostCards(
        @Query("access_token") apiKey: String = "US4V254pqZQICK9ejRdem9pMwU7S874bU2",
        @Query("page") page: Int
    ): Call<GetCardsResponse>

    @GET("hearthstone/cards?locale=en_US&manaCost=2")
    fun getTwoManaCostCards(
        @Query("access_token") apiKey: String = "US4V254pqZQICK9ejRdem9pMwU7S874bU2",
        @Query("page") page: Int
    ): Call<GetCardsResponse>

    @GET("hearthstone/cards?locale=en_US&manaCost=3")
    fun getThreeManaCostCards(
        @Query("access_token") apiKey: String = "US4V254pqZQICK9ejRdem9pMwU7S874bU2",
        @Query("page") page: Int
    ): Call<GetCardsResponse>

    @GET("hearthstone/cards?locale=en_US&manaCost=4")
    fun getFourManaCostCards(
        @Query("access_token") apiKey: String = "US4V254pqZQICK9ejRdem9pMwU7S874bU2",
        @Query("page") page: Int
    ): Call<GetCardsResponse>

    @GET("hearthstone/cards?locale=en_US&manaCost=5")
    fun getFiveManaCostCards(
        @Query("access_token") apiKey: String = "US4V254pqZQICK9ejRdem9pMwU7S874bU2",
        @Query("page") page: Int
    ): Call<GetCardsResponse>

    @GET("hearthstone/cards?locale=en_US&manaCost=6")
    fun getSixManaCostCards(
        @Query("access_token") apiKey: String = "US4V254pqZQICK9ejRdem9pMwU7S874bU2",
        @Query("page") page: Int
    ): Call<GetCardsResponse>
}