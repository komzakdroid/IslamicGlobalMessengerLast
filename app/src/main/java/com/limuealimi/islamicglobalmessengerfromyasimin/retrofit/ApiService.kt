package com.limuealimi.islamicglobalmessengerfromyasimin.retrofit

import com.limuealimi.islamicglobalmessengerfromyasimin.models.UserData
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.QueryName

interface ApiService {
    @GET("/")
    fun nameCheck(@Query("name") name: String): Call<UserData>
}