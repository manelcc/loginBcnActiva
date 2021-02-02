package es.manel.loginbcnactiva.core.storage

import java.lang.Exception
import kotlin.jvm.Throws

interface SharePersistence {

    fun readUser(): String
    fun saveUser(userName: String)

    fun fakeLogin(userName: String, password: String): Boolean
}