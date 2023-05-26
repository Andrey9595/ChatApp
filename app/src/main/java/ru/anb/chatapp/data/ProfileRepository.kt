package ru.anb.chatapp.data

import ru.anb.chatapp.R
import ru.anb.chatapp.models.LoadState
import ru.anb.chatapp.models.updateuser.UpdateUser
import ru.anb.chatapp.models.user.ProfileData
import ru.anb.chatapp.retrofit.ProfileApi
import javax.inject.Inject

class ProfileRepository @Inject constructor(private val profileApi: ProfileApi) {

    suspend fun getProfile(request: ProfileData): LoadState<ProfileData> {
        val result = profileApi.profile(request)
        return if (result.isSuccessful)
            LoadState.Success(result.body())
        else LoadState.Error(R.string.not_found)
    }

    suspend fun updateProfile(request: UpdateUser): LoadState<UpdateUser> {
        val result = profileApi.updateProfile(request)
        return if (result.isSuccessful)
            LoadState.Success(result.body())
        else LoadState.Error(R.string.not_found)
    }

}