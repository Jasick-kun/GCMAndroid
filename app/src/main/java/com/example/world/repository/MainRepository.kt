package com.mrntlu.tokenauthentication.repository

import com.example.world.service.main.MainApiService
import com.example.world.utils.apiRequestFlow
import javax.inject.Inject

class MainRepository @Inject constructor(
    private val mainApiService: MainApiService,
) {
    fun getUserInfo() = apiRequestFlow {
        mainApiService.getUserInfo()
    }
}