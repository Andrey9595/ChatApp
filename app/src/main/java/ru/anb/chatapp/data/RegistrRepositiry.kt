package ru.anb.chatapp.data

import ru.anb.chatapp.R
import ru.anb.chatapp.models.LoadState
import ru.anb.chatapp.models.registration.RegistrationRequest
import ru.anb.chatapp.models.registration.RegistrationResponse
import ru.anb.chatapp.retrofit.RegistrApi
import javax.inject.Inject

class RegistrRepositiry @Inject constructor(private val registrApi: RegistrApi) {

    suspend fun sendRegistration(request: RegistrationRequest): LoadState<RegistrationResponse> {
        val result = registrApi.registration(request)
        return if(result.isSuccessful)
            LoadState.Success(result.body())
        else LoadState.Error(R.string.not_found)
    }
}