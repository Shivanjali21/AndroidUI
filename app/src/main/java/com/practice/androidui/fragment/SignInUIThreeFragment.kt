package com.practice.androidui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.practice.androidui.R
import com.practice.androidui.databinding.FragmentSignInUIThreeBinding

class SignInUIThreeFragment : Fragment(R.layout.fragment_sign_in_u_i_three) {

    private val binding : FragmentSignInUIThreeBinding by lazy {
       FragmentSignInUIThreeBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment


        return binding.root
    }


}