package ru.anb.chatapp.ui.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.anb.chatapp.data.AuthRepository
import ru.anb.chatapp.domain.AuthState
import ru.anb.chatapp.models.autorization.CheckAuthCodeRequest
import ru.anb.chatapp.models.autorization.SendAuthCodeRequest
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(private val repository: AuthRepository) :
    ViewModel() {

    private val _authState = MutableStateFlow<AuthState>(AuthState.initial)
    val authState get() = _authState.asStateFlow()

    fun sendPhone(phone: String) {
        viewModelScope.launch {
            val result = repository.sendPhone(SendAuthCodeRequest(phone))
            _authState.value = _authState.value.copy(sendLoadState = result)
        }
    }

    fun checkCode(phone: String, code: String) {
        viewModelScope.launch {
            val result = repository.checkCode(CheckAuthCodeRequest(phone, code))
            _authState.value = _authState.value.copy(checkLoadState = result)
        }
    }
}