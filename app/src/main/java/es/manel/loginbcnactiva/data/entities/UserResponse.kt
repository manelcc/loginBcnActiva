package es.manel.loginbcnactiva.data.entities

import com.google.gson.annotations.SerializedName

data class UserResponse(
    @SerializedName("token")
    val token: String
)
