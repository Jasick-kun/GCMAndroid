package com.example.world.models

import com.google.gson.annotations.SerializedName;

data class Auth(
    val login: String,
    val password: String,
    val firebaseToken: String
)