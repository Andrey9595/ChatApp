package ru.anb.chatapp.data

data class Message(
    val text: String,
    val type: MessageType
)

enum class MessageType{
    OUTGOING,
    INCOMING
}


