package es.manel.loginbcnactiva.data

import es.manel.loginbcnactiva.core.storage.SharePersistence
import javax.inject.Inject

class LoginRepository @Inject constructor(private val persistence:SharePersistence){

    fun nameUser() : String = persistence.readUser()
}