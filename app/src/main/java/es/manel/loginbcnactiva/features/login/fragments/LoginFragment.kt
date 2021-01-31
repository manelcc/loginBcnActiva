package es.manel.loginbcnactiva.features.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import es.manel.loginbcnactiva.R
import es.manel.loginbcnactiva.databinding.LoginFragmentLoginBinding
import es.manel.loginbcnactiva.features.login.vm.MainLoginViewModel
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {
    private var _binding: LoginFragmentLoginBinding? = null
    private val binding get() = _binding!!

    val viewModel : MainLoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentLoginBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        binding.message.text = viewModel.getName()

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.login_to_registred)
        }

        binding.loginBtnHome.setOnClickListener {
            findNavController().navigate(R.id.login_to_home)
        }

    }

}