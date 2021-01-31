package es.manel.loginbcnactiva.data.api

import es.manel.loginbcnactiva.data.entities.UserResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST


interface ApiLogin {
    @Headers("Content-Type: application/json; charset=utf-8")
    @POST("/api/login")
    suspend fun logIn(
        @Body body: Map<String,String>
    ): Response<UserResponse>
}