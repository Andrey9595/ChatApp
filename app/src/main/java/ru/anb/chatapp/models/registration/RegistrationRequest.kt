package ru.anb.chatapp.models.registration

data class RegistrationRequest(
    val phone: String,
    val name: String,
    val username: String
)