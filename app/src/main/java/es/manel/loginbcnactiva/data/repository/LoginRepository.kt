package es.manel.loginbcnactiva.data.repository

import es.manel.loginbcnactiva.core.storage.SharePersistence
import es.manel.loginbcnactiva.data.api.ApiLogin
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val persistence: SharePersistence,
    private val apiLogin: ApiLogin
) {

    fun nameUser(): String = persistence.readUser()


    fun fakeLogin(): Boolean = persistence.fakeLogin("userName", "1234")

    @ExperimentalStdlibApi
    fun postLogin(username:String, password:String): Flow<Boolean> {
        return flow {
            emit(apiLogin.logIn(mapOf("email" to username).plus("password" to password)))
        }.map { it.code() == 200 }

    }
}