package ru.anb.chatapp.data

import ru.anb.chatapp.domain.ChatListRepository
import ru.anb.chatapp.models.chat.Chat
import ru.anb.chatapp.models.chat.ChatHead
import java.util.*

class ChatListRepositoryImpl : ChatListRepository {
    // база чатов
    private val chats = mutableListOf<Chat>()

    init {
        // сообщения в чате с рандомным текстом и типоп входящих и исходящих сообщениях
        val messages = mutableListOf<Message>()
        for (i in 1..20)
            messages.add(
                Message(
                    text = UUID.randomUUID().toString() + UUID.randomUUID().toString(),
                    type = if (i % 2 == 0) MessageType.INCOMING else MessageType.OUTGOING
                )
            )
        // список чатов и база сообщений
        for (i in 1..20) {
            chats.add(Chat(id = i, messages = messages))
        }
    }

    override fun getChats(): List<ChatHead> {
        val list = mutableListOf<ChatHead>()
        for (i in 1..20) {
            list.add(ChatHead(i, "message$i", "chat$i"))
        }
        return list
    }

    override fun getChat(id: Int): Chat? {
      return chats.find {
          it.id == id
      }
    }
}