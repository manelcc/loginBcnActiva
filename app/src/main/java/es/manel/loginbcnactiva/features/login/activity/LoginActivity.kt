package es.manel.loginbcnactiva.features.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import es.manel.loginbcnactiva.R

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}