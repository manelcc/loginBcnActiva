package es.manel.loginbcnactiva.core.storage

import android.content.Context
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class SharePersistenceImpl @Inject constructor(@ApplicationContext context: Context) : SharePersistence {

    override fun readUser(): String {
       return "manel"
    }

    override fun saveUser() {
        TODO("Not yet implemented")
    }
}