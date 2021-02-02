package es.manel.loginbcnactiva

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class LoginBcnApp : Application() {

    override fun onCreate() {
        super.onCreate()
        //init after firebase
    }
}