package ru.anb.chatapp.ui.registration

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import ru.anb.chatapp.data.RegistrRepositiry
import ru.anb.chatapp.models.LoadState
import ru.anb.chatapp.models.registration.RegistrationRequest
import ru.anb.chatapp.models.registration.RegistrationResponse
import javax.inject.Inject

@HiltViewModel
class RegistrationViewModel @Inject constructor(private val repository: RegistrRepositiry):ViewModel() {

    private val _authState = MutableStateFlow<LoadState<RegistrationResponse>>(LoadState.NotLoadedYet())
    val registrState get() = _authState.asStateFlow()


    fun registration(phone: String, name: String, username: String){
        viewModelScope.launch {
            val result = repository.sendRegistration(RegistrationRequest(phone, name, username))
            _authState.value = result
        }

    }
}