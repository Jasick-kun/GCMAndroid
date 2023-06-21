package com.example.world.service.message

import com.example.world.models.Auth
import com.example.world.models.LoginResponse
import com.example.world.models.Message
import com.google.android.datatransport.runtime.dagger.Module
import dagger.Binds
import dagger.Component
import dagger.Provides
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
@Module
@EntryPoint
@InstallIn(ViewModelComponent::class)
interface MessageApiService {

    @GET("message/all")
    suspend fun all(): Response<List<Message>>

}