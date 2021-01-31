package es.manel.loginbcnactiva.features.login.vm

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.manel.loginbcnactiva.data.LoginRepository


class MainLoginViewModel @ViewModelInject constructor(private val repo:LoginRepository): ViewModel() {

    private val _logIn:MutableLiveData<Boolean> = MutableLiveData()
    val logIn : LiveData<Boolean> get() = _logIn

   init {
       _logIn.value = repo.fakeLogin()
   }

    fun logInUser(username:String,password:String){
        _logIn.value = repo.fakeLogin()
    }

}