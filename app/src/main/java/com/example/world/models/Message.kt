package com.example.world.models

import java.sql.RowIdLifetime
import java.sql.Time
import java.util.Date

data class Message (
    val id: String,
    val messageId: String,
    val title: String,
    val body: String,
    val date: Date,
    val lifetime: Time,
    val isOpened: Boolean,

    val user: User
)