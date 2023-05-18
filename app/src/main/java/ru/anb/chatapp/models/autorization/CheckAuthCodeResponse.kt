package ru.anb.chatapp.models.autorization


import com.google.gson.annotations.JsonAdapter
import com.google.gson.annotations.SerializedName

data class CheckAuthCodeResponse(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("is_user_exists")
    val isUserExists: Boolean,
    @SerializedName("refresh_token")
    val refreshToken: String,
    @SerializedName("user_id")
    val userId: Int
)