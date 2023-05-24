package ru.anb.chatapp.models.autorization

data class CheckAuthCodeRequest(
    val phone: String,
    val code: String
)