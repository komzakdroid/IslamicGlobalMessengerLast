package com.limuealimi.islamicglobalmessengerfromyasimin.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import java.util.*

object ApiClient {
    const val BASE_URL = "https://api.genderize.io"

    //?name=peter&apikey=edfcd65ad93fcde6e1efac9bc71c3a13
    fun getRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    val apiService: ApiService = getRetrofit().create(ApiService::class.java)

}