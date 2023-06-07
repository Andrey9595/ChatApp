package ru.anb.chatapp.models.chat

import ru.anb.chatapp.data.Message

data class ChatHead(
    val id: Int,
    val lastMessage: String,
    val chatMane: String
)

data class Chat(
    val id: Int,
    val messages: List<Message>
)
