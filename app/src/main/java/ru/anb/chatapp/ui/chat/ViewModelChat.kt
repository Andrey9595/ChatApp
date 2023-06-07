package ru.anb.chatapp.ui.chat

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import ru.anb.chatapp.domain.ChatListRepository
import javax.inject.Inject


@HiltViewModel
class ViewModelChat @Inject constructor(private val chatListRepository: ChatListRepository) :
    ViewModel() {

    fun getChatList() = chatListRepository.getChats()

}