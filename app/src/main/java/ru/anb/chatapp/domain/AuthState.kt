package ru.anb.chatapp.domain

data class AuthState(
    val phone: String,
    val code: String,
) {
    companion object{
        val initial = AuthState("", "")
    }

}

