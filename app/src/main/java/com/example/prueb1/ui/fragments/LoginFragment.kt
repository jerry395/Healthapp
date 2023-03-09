package com.example.prueb1.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.prueb1.R
import com.example.prueb1.databinding.FragmentLoginBinding
import com.example.prueb1.isValidEmail
import com.example.prueb1.isValidPassword
import com.example.prueb1.ui.activities.HomeActivity

/**
 * A simple [Fragment] subclass.
 * Use the [LoginFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding:FragmentLoginBinding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
            }


    override fun onStart() {
        super.onStart()
        binding.fragmentLoginForgotButton.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_forgotFragment)
        }
        binding.framentLabelRegistrate.setOnClickListener {

            findNavController().navigate(R.id.action_loginFragment_to_signUpFragment)
        }

        binding.fragmentLoginButton.setOnClickListener {
            if (!binding.fragmentEmailText.text.toString().isValidEmail()) {
                        binding.loginFragmentEmailLayaout.error = "Email no Valido" }
            else {
                    binding.loginFragmentEmailLayaout.error = null  }

            if (!binding.fragmentPasswordText.text.toString().isValidPassword()) {
                    binding.loginFragmentPasswordLayaout.error = "Contraseña no Valida" }
            else {
                binding.loginFragmentPasswordLayaout.error = null  }

            if(binding.fragmentEmailText.text.toString().isValidEmail() && binding.fragmentPasswordText.text.toString().isValidPassword()) {
                val intent = Intent(requireContext(), HomeActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
                 }
            }

        }
    }



