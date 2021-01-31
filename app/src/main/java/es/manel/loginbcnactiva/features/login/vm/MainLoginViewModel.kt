package es.manel.loginbcnactiva.features.login.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.manel.loginbcnactiva.data.LoginRepository


class MainLoginViewModel @ViewModelInject constructor(private val repo:LoginRepository): ViewModel() {
    fun getName(): String {
        return repo.nameUser()
    }

}