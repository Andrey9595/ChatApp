package ru.anb.chatapp.data

import ru.anb.chatapp.domain.ChatListRepository
import ru.anb.chatapp.models.chat.ChatModel

class ChatListRepositoryImpl: ChatListRepository {
    override fun getChats(): List<ChatModel> {
        val list = mutableListOf<ChatModel>()
        for (i in 1..20){
            list.add(ChatModel(i,"message$i", "chat$i"))
        }
        return list
    }
}