package com.example.world.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.world.models.UserInfoResponse
import com.example.world.utils.ApiResponse
import com.example.world.viewmodels.BaseViewModel
import com.example.world.viewmodels.CoroutinesErrorHandler
import com.mrntlu.tokenauthentication.repository.MainRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
): BaseViewModel() {

    private val _userInfoResponse = MutableLiveData<ApiResponse<UserInfoResponse>>()
    val userInfoResponse = _userInfoResponse

    fun getUserInfo(coroutinesErrorHandler: CoroutinesErrorHandler) = baseRequest(
        _userInfoResponse,
        coroutinesErrorHandler,
    ) {
        mainRepository.getUserInfo()
    }
}