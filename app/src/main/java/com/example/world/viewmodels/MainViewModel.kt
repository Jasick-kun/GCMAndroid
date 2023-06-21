package com.example.world.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.world.utils.ApiResponse
import com.mrntlu.tokenauthentication.repository.MainRepository

import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
): BaseViewModel() {


}