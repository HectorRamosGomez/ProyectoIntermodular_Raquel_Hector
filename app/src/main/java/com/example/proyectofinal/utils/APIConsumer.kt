package com.example.proyectofinal.utils

import com.example.proyectofinal.data.UniqueEmailValidationResponse
import com.example.proyectofinal.data.ValidateEmailBody
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIConsumer {
    @POST("users/validate_unique_email")
        suspend fun validarEmail(@Body body: ValidateEmailBody): Response<UniqueEmailValidationResponse>
}