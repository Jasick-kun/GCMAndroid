package com.example.world.viewmodels

import androidx.lifecycle.MutableLiveData
import com.example.world.models.Auth
import com.example.world.models.LoginResponse
import com.example.world.models.Message
import com.example.world.repository.AuthRepository
import com.example.world.repository.MessageRepository
import com.example.world.utils.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class MessageViewModel @Inject constructor(
    private val messageRepository: MessageRepository,
): BaseViewModel() {

    private val _message = MutableLiveData<ApiResponse<List<Message>>>()
    val message = _message

    fun all(coroutinesErrorHandler: CoroutinesErrorHandler) = baseRequest(
        _message,
        coroutinesErrorHandler)
     {
        messageRepository.all();
    }
}