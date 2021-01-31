package es.manel.loginbcnactiva.features.login.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import es.manel.loginbcnactiva.R
import es.manel.loginbcnactiva.databinding.LoginFragmentBinding
import es.manel.loginbcnactiva.features.login.vm.MainLoginViewModel

class LoginFragment : Fragment() {
    private var _binding: LoginFragmentBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewViewModel: MainLoginViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = LoginFragmentBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewViewModel = ViewModelProvider(this).get(MainLoginViewModel::class.java)

        binding.loginBtn.setOnClickListener {
            findNavController().navigate(R.id.login_to_registred)
        }

        binding.loginBtnHome.setOnClickListener {
            findNavController().navigate(R.id.login_to_home)
        }


    }

}