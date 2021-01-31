package es.manel.loginbcnactiva.features.login.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.manel.loginbcnactiva.R
import es.manel.loginbcnactiva.features.login.view.fragments.LoginFragment

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, LoginFragment.newInstance())
                .commitNow()
        }
    }
}