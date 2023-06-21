package com.example.world.repository

import com.example.world.models.Auth
import com.example.world.service.message.MessageApiService
import com.example.world.utils.apiRequestFlow
import javax.inject.Inject

class MessageRepository @Inject constructor(
    private val messageApiService: MessageApiService
){
    fun all() = apiRequestFlow {
       messageApiService.all();
    }
}