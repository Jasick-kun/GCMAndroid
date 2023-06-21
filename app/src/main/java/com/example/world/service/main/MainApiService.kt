package com.example.world.service.main

import com.example.world.models.UserInfoResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainApiService {
    @GET("users/all")
    suspend fun getUserInfo(): Response<UserInfoResponse>
}