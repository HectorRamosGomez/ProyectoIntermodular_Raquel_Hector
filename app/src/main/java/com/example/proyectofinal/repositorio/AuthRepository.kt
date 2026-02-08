package com.example.proyectofinal.repositorio

import com.example.proyectofinal.data.UniqueEmailValidationResponse
import com.example.proyectofinal.data.ValidateEmailBody
import com.example.proyectofinal.utils.APIConsumer
import com.example.proyectofinal.utils.RequestStatus
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class AuthRepository(val consumer: APIConsumer) {

    fun validateEmailAddress(body: ValidateEmailBody) = flow {
        emit(RequestStatus.Waiting)

        try {
            val response = consumer.validarEmail(body)
            if (response.isSuccessful) {
                emit(RequestStatus.Succes(response.body()!!))
            } else {
                val errorJson = response.errorBody()?.string()

                if (errorJson != null && errorJson.contains("false")) {
                    emit(RequestStatus.Error("Este correo electrónico ya está en uso"))
                } else {
                    emit(RequestStatus.Error("Error en el servidor: ${response.code()}"))
                }
            }
        } catch (e: Exception) {
            emit(RequestStatus.Error("Revisa tu conexión a internet"))
        }
    }
}