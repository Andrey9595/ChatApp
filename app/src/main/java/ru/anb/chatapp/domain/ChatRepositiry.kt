package ru.anb.chatapp.domain

import ru.anb.chatapp.models.chat.Chat
import ru.anb.chatapp.models.chat.ChatHead

interface ChatListRepository {

    fun getChats(): List<ChatHead>

    fun getChat(id: Int): Chat?
}