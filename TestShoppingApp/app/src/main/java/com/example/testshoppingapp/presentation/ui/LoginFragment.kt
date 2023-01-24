package com.example.testshoppingapp.presentation.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.testshoppingapp.R
import com.example.testshoppingapp.databinding.FragmentLoginBinding
import com.google.android.material.snackbar.Snackbar
import com.example.testshoppingapp.data.util.Utils.checkLoginRequestFields
import com.example.testshoppingapp.presentation.viewmodel.LoginViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : Fragment() {

    @Inject
    lateinit var viewModel: LoginViewModel
    private lateinit var binding : FragmentLoginBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding = FragmentLoginBinding.bind(view)

        binding.emailEditTextLoginFragment.setText("jimmie_k")
        binding.passwordEditTextLoginFragment.setText("klein*#%*")

        binding.ButtonLoginFragment.setOnClickListener {

            val username = binding.emailEditTextLoginFragment.editableText.toString()
            val password = binding.passwordEditTextLoginFragment.editableText.toString()

            val result = checkLoginRequestFields(username, password)

            if (result.successful){
                viewModel.loginUser(username, password)
                viewModel.successful.observe(viewLifecycleOwner){successful ->
                    if (successful == true){
                        binding.ButtonLoginFragment.isEnabled = true
                        findNavController().navigate(R.id.action_loginFragment_to_homeFragment)
                        viewModel.navigated()
                    }else if(successful == false){
                        binding.ButtonLoginFragment.isEnabled = true
                        Snackbar.make(binding.ButtonLoginFragment,"${viewModel.error.value}",Snackbar.LENGTH_SHORT).show()
                        viewModel.navigated()
                    }
                }
            }
            else{
                Snackbar.make(binding.ButtonLoginFragment,"${result.error}",Snackbar.LENGTH_SHORT).show()
            }

        }

    }



}