package es.manel.loginbcnactiva.features.login.fragments

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.manel.loginbcnactiva.R
import es.manel.loginbcnactiva.features.login.vm.RegistredViewModel

class RegistredFragment : Fragment() {

    companion object {
        fun newInstance() = RegistredFragment()
    }

    private lateinit var viewModel: RegistredViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.login_fragment_registred, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistredViewModel::class.java)
        // TODO: Use the ViewModel
    }

}