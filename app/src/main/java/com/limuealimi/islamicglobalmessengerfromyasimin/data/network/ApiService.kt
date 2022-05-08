package com.limuealimi.islamicglobalmessengerfromyasimin.data.network

import com.limuealimi.islamicglobalmessengerfromyasimin.data.models.UserData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("/")
    suspend fun getUserGender(
        @Query("name") name: String
    ): Result<UserData>
}