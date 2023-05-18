package ru.anb.chatapp.models.autorization

data class CheckAuthCodeRequest(
    val code: String,
    val phone: String
)