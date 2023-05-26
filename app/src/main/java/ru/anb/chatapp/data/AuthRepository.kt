package ru.anb.chatapp.data

import ru.anb.chatapp.R
import ru.anb.chatapp.models.LoadState
import ru.anb.chatapp.models.autorization.CheckAuthCodeRequest
import ru.anb.chatapp.models.autorization.CheckAuthCodeResponse
import ru.anb.chatapp.models.autorization.SendAuthCodeRequest
import ru.anb.chatapp.models.autorization.SendAuthCodeResponse
import ru.anb.chatapp.retrofit.AuthApi
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authApi: AuthApi) {

    suspend fun sendPhone(request: SendAuthCodeRequest): LoadState<SendAuthCodeResponse> {
        val result = authApi.sendAuthCode(request)
        return if (result.isSuccessful)
            LoadState.Success(result.body())
        else LoadState.Error(R.string.not_found)
    }

    suspend fun checkCode(request: CheckAuthCodeRequest): LoadState<CheckAuthCodeResponse> {
        val result = authApi.checkAuthCode(request).body()
        return if (result != null) {
            if (result.isUserExists)
                LoadState.UserIsExist(result)
            else LoadState.UserIsMotExist(result)
        } else LoadState.Error(R.string.not_found)
    }
}