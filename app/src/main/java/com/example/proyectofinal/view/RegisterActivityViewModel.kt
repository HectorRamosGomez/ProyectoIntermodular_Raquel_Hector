package com.example.proyectofinal.view

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectofinal.data.User
import com.example.proyectofinal.data.ValidateEmailBody
import com.example.proyectofinal.repositorio.AuthRepository
import com.example.proyectofinal.utils.RequestStatus
import kotlinx.coroutines.launch

class RegisterActivityViewModel(val authRepository: AuthRepository, val application: Application): ViewModel() {
    private var isLoading: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }
    private var errorMessage: MutableLiveData<HashMap<String, String>> = MutableLiveData()
    private var isUniqueEmail: MutableLiveData<Boolean> =
        MutableLiveData<Boolean>().apply { value = false }
    private var user: MutableLiveData<User> = MutableLiveData()

    fun getIsLoading(): LiveData<Boolean> = isLoading
    fun getErrorMessage(): LiveData<HashMap<String, String>> = errorMessage
    fun getIsUnique(): LiveData<Boolean> = isUniqueEmail
    fun getUser(): LiveData<User> = user

    fun validateEmailAddress(body: ValidateEmailBody) {
        viewModelScope.launch {
            authRepository.validateEmailAddress(body).collect {
                when (it) {
                    is RequestStatus.Waiting -> {
                        isLoading.value = true
                    }

                    is RequestStatus.Succes -> {
                        isLoading.value = false
                        isUniqueEmail.value = it.data.isUnique
                        user.value = it.data.user
                    }

                    is RequestStatus.Error -> {
                        isLoading.value = false
                        errorMessage.value = hashMapOf("error" to it.message)
                    }
                }
            }
        }
    }
}
