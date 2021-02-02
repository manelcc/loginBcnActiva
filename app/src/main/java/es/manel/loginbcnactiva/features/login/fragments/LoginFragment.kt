package es.manel.loginbcnactiva.features.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.core.widget.doAfterTextChanged
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import es.app.laliguilla.core.extension.isEmail
import es.app.laliguilla.core.extension.isValidPass
import es.manel.loginbcnactiva.R
import es.manel.loginbcnactiva.databinding.LoginFragmentLoginBinding
import es.manel.loginbcnactiva.features.login.vm.MainLoginViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi

@ExperimentalCoroutinesApi
@ExperimentalStdlibApi
@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: LoginFragmentLoginBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MainLoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        launchHomeIfLogIn()
        listenerUserName()
        listenerPassword()
        listenerBtn()
    }



    private fun listenerBtn() {
        binding.loginBtn.setOnClickListener {
            val username = binding.loginInputlayoutUsername.editText?.text.toString()
            val password = binding.loginInputlayoutPassword.editText?.text.toString()
            if (validateUserName(username) && validatePassword(password)) {
                viewModel.logInUser(username, password)
            }
        }
    }

    private fun listenerPassword() {
        binding.loginInputlayoutPassword.editText?.doAfterTextChanged {
            it?.apply {
                when {
                    length > 1 -> binding.loginInputlayoutPassword.error = null
                }
            }
        }
    }

    private fun listenerUserName() {
        binding.loginInputlayoutUsername.editText?.doAfterTextChanged {
            it?.apply {
                when {
                    length > 1 -> binding.loginInputlayoutUsername.error = null
                }
            }
        }
    }

    private fun validatePassword(password: String): Boolean {
        return when (password.isValidPass()) {
            true -> {
                binding.loginInputlayoutPassword.error = null; true
            }
            false -> {
                binding.loginInputlayoutPassword.error = "Ups password incorrecto"; false
            }
        }
    }

    private fun validateUserName(username: String): Boolean {
        return when (username.isEmail()) {
            true -> {
                binding.loginInputlayoutUsername.error = null; true
            }
            false -> {
                binding.loginInputlayoutUsername.error = "Ups verifica tu usuario"; false
            }
        }
    }

    private fun launchHomeIfLogIn() {
        viewModel.logIn.observe(viewLifecycleOwner, {
            when (it) {
                true -> findNavController().navigate(R.id.login_to_home)
            }
        })
    }

}