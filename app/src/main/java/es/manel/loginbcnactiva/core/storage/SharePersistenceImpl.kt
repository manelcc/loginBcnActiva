package es.manel.loginbcnactiva.core.storage

import android.content.Context
import android.content.SharedPreferences
import dagger.hilt.android.qualifiers.ApplicationContext
import java.lang.Exception
import javax.inject.Inject
import kotlin.jvm.Throws

class SharePersistenceImpl @Inject constructor(@ApplicationContext private val context: Context) : SharePersistence {

    private var preferences: SharedPreferences? = context.getSharedPreferences("userDates",Context.MODE_PRIVATE)

    override fun readUser(): String {
        return "manel"
    }

    override fun saveUser(userName: String) {
        val sharedPref = preferences?: return
        with (sharedPref.edit()) {
           putString("user",userName)
            apply()
        }
    }

    @Throws(Exception::class)
    override fun fakeLogin(userName:String, password:String): Boolean {
        return false
    }
}