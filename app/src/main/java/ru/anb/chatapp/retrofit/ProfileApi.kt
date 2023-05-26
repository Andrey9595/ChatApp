package ru.anb.chatapp.retrofit

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import ru.anb.chatapp.models.updateuser.UpdateUser
import ru.anb.chatapp.models.user.ProfileData

interface ProfileApi {

    @GET("users/me/")
    suspend fun profile(@Body body: ProfileData): Response<ProfileData>

    @PUT("users/me/")
    suspend fun updateProfile(@Body body: UpdateUser): Response<UpdateUser>

}