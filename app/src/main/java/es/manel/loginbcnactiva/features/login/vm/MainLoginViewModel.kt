package es.manel.loginbcnactiva.features.login.vm

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import es.manel.loginbcnactiva.data.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch


@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
class MainLoginViewModel @ViewModelInject constructor(private val repo: LoginRepository): ViewModel() {

    private val _logIn:MutableLiveData<Boolean> = MutableLiveData()
    val logIn : LiveData<Boolean> get() = _logIn

   init {
       _logIn.value = repo.fakeLogin()
   }


    fun logInUser(username:String, password:String){
        viewModelScope.launch {
            repo.postLogin(username, password)
                .catch {
                    Log.e("manel","error "+it.message)
                    _logIn.value = false }
                .collect { _logIn.value = it }

        }
    }

}