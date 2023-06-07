package ru.anb.chatapp.ui.onechat

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.anb.chatapp.domain.ChatListRepository
import ru.anb.chatapp.models.chat.Chat
import javax.inject.Inject

@HiltViewModel
class OneChatViewModel@Inject constructor(private val chatListRepository: ChatListRepository): ViewModel() {

    fun getMessages(id: Int): Chat? {
        return chatListRepository.getChat(id)
    }
}