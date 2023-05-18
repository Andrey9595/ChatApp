package ru.anb.chatapp.models.registration

data class RegistrationRequest(
    val name: String,
    val phone: String,
    val username: String
)