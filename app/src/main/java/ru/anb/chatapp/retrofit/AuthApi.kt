package ru.anb.chatapp.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.anb.chatapp.models.autorization.CheckAuthCodeRequest
import ru.anb.chatapp.models.autorization.CheckAuthCodeResponse
import ru.anb.chatapp.models.autorization.SendAuthCodeRequest
import ru.anb.chatapp.models.autorization.SendAuthCodeResponse

interface AuthApi {

    @POST("users/send-auth-code/")
    suspend fun sendAuthCode(@Body body: SendAuthCodeRequest): Response<SendAuthCodeResponse>

    @POST("users/check-auth-code/")
    suspend  fun checkAuthCode(@Body body: CheckAuthCodeRequest): Response<CheckAuthCodeResponse>
}