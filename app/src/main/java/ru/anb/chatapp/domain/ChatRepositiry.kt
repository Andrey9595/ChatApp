package ru.anb.chatapp.domain

import ru.anb.chatapp.models.chat.ChatModel

interface ChatListRepository {

    fun getChats(): List<ChatModel>

}