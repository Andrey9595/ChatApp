package ru.anb.chatapp.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import ru.anb.chatapp.models.registration.RegistrationRequest
import ru.anb.chatapp.models.registration.RegistrationResponse

interface RegistrApi {
    @POST("/users/register/")
    suspend  fun registration(@Body body: RegistrationRequest): Response<RegistrationResponse>
}