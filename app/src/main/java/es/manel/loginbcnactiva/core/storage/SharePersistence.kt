package es.manel.loginbcnactiva.core.storage

interface SharePersistence {

    fun readUser() : String
    fun saveUser()
}