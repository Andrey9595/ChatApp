package ru.anb.chatapp.models

import ru.anb.chatapp.models.autorization.CheckAuthCodeResponse
import ru.anb.chatapp.models.autorization.SendAuthCodeResponse

// описываем экран авторизации
data class AuthState(
    val sendLoadState: LoadState<SendAuthCodeResponse>,
    val checkLoadState: LoadState<CheckAuthCodeResponse>
) {
    companion object {
        val initial = AuthState(LoadState.NotLoadedYet(), LoadState.NotLoadedYet())
    }
}

