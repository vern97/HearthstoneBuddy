package com.example.hearthstonebuddy.BlizzardAPI

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CardsRepository {

    private val api: Api

    init {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://us.api.blizzard.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        api = retrofit.create(Api::class.java)
    }

    fun getAllCards(
        page: Int = 1,
        onSuccess: (movies: List<Card>) -> Unit,
        onError: () -> Unit
    ) {
        api.getAllCards(page = page)
            .enqueue(object : Callback<GetCardsResponse> {
                override fun onResponse(
                    call: Call<GetCardsResponse>,
                    response: Response<GetCardsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.cards)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetCardsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getOneManaCostCards(
        page: Int = 1,
        onSuccess: (movies: List<Card>) -> Unit,
        onError: () -> Unit
    ) {
        api.getOneManaCostCards(page = page)
            .enqueue(object : Callback<GetCardsResponse> {
                override fun onResponse(
                    call: Call<GetCardsResponse>,
                    response: Response<GetCardsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.cards)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetCardsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getTwoManaCostCards(
        page: Int = 1,
        onSuccess: (movies: List<Card>) -> Unit,
        onError: () -> Unit
    ) {
        api.getTwoManaCostCards(page = page)
            .enqueue(object : Callback<GetCardsResponse> {
                override fun onResponse(
                    call: Call<GetCardsResponse>,
                    response: Response<GetCardsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.cards)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetCardsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getThreeManaCostCards(
        page: Int = 1,
        onSuccess: (movies: List<Card>) -> Unit,
        onError: () -> Unit
    ) {
        api.getThreeManaCostCards(page = page)
            .enqueue(object : Callback<GetCardsResponse> {
                override fun onResponse(
                    call: Call<GetCardsResponse>,
                    response: Response<GetCardsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.cards)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetCardsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getFourManaCostCards(
        page: Int = 1,
        onSuccess: (movies: List<Card>) -> Unit,
        onError: () -> Unit
    ) {
        api.getFourManaCostCards(page = page)
            .enqueue(object : Callback<GetCardsResponse> {
                override fun onResponse(
                    call: Call<GetCardsResponse>,
                    response: Response<GetCardsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.cards)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetCardsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getFiveManaCostCards(
        page: Int = 1,
        onSuccess: (movies: List<Card>) -> Unit,
        onError: () -> Unit
    ) {
        api.getFiveManaCostCards(page = page)
            .enqueue(object : Callback<GetCardsResponse> {
                override fun onResponse(
                    call: Call<GetCardsResponse>,
                    response: Response<GetCardsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.cards)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetCardsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

    fun getSixManaCostCards(
        page: Int = 1,
        onSuccess: (movies: List<Card>) -> Unit,
        onError: () -> Unit
    ) {
        api.getSixManaCostCards(page = page)
            .enqueue(object : Callback<GetCardsResponse> {
                override fun onResponse(
                    call: Call<GetCardsResponse>,
                    response: Response<GetCardsResponse>
                ) {
                    if (response.isSuccessful) {
                        val responseBody = response.body()
                        if (responseBody != null) {
                            onSuccess.invoke(responseBody.cards)
                        } else {
                            onError.invoke()
                        }
                    } else {
                        onError.invoke()
                    }
                }
                override fun onFailure(call: Call<GetCardsResponse>, t: Throwable) {
                    onError.invoke()
                }
            })
    }

}