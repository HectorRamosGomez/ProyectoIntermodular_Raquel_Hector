package com.example.proyectofinal.utils

import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface APIConsumer {
    @POST("users/validate_unique_email")
    suspend fun validarEmail(@Body body: Map<String, String>): Response<Map<String, Any>>
}