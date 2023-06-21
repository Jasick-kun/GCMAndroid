package com.example.world.repository

import com.example.world.models.Auth
import com.example.world.service.auth.AuthApiService
import com.example.world.utils.apiRequestFlow
import javax.inject.Inject

class AuthRepository @Inject constructor(
    private val authApiService: AuthApiService,
) {
    fun login(auth: Auth) = apiRequestFlow {
        authApiService.login(auth)
    }
}