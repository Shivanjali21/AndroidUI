package com.practice.androidui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.practice.androidui.R
import com.practice.androidui.databinding.FragmentSignUpUIOneBinding

class SignUpUIOneFragment : Fragment(R.layout.fragment_sign_up_u_i_one) {

    private val binding : FragmentSignUpUIOneBinding by lazy {
       FragmentSignUpUIOneBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        binding.apply {
            tvSSubTitle.setOnClickListener {
              findNavController().navigate(R.id.action_signUpUIOneFragment_to_signInUIOneFragment)
            }
        }
        return binding.root
    }

}