package ru.anb.chatapp.ui.chat

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import ru.anb.chatapp.domain.ChatListRepository
import ru.anb.chatapp.models.AuthState
import javax.inject.Inject


@HiltViewModel
class ViewModelChat @Inject constructor(private val chatListRepository: ChatListRepository) :
    ViewModel() {

    fun getChatList() = chatListRepository.getChats()

}