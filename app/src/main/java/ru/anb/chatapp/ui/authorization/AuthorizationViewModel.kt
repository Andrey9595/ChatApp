package ru.anb.chatapp.ui.authorization

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.anb.chatapp.di.LoadState
import ru.anb.chatapp.domain.AuthState
import ru.anb.chatapp.models.autorization.CheckAuthCodeRequest
import ru.anb.chatapp.retrofit.AuthApi
import javax.inject.Inject

@HiltViewModel
class AuthorizationViewModel @Inject constructor(private val authApi: AuthApi) : ViewModel() {

    private val _authState = MutableStateFlow<LoadState<AuthState>>(LoadState.Success(AuthState.initial))
    val authState get() = _authState.asStateFlow()

    fun sendPhone(phone: String) {
        viewModelScope.launch {
            _authState.value = LoadState.Loading()
            delay(1000)
            _authState.value = LoadState.Success()
        }
    }

    fun checkCode(code: String, phone: String){
       viewModelScope.launch {
           _authState.value = LoadState.Loading()
           authApi.checkAuthCode(CheckAuthCodeRequest("133337", phone))
       }
    }
}