package com.practice.androidui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.androidui.R
import com.practice.androidui.databinding.FragmentSignInUIOneBinding

class SignInUIOneFragment : Fragment(R.layout.fragment_sign_in_u_i_one) {

    private val binding : FragmentSignInUIOneBinding by lazy {
       FragmentSignInUIOneBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {

        binding.apply {
            tvSubTitle.setOnClickListener {
              val loginAction = SignInUIOneFragmentDirections.actionSignInUIOneFragmentToSignUpUIOneFragment()
              findNavController().navigate(loginAction)
            }
        }

        return binding.root
    }

}