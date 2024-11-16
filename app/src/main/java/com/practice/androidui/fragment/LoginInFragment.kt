package com.practice.androidui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.practice.androidui.R
import com.practice.androidui.databinding.FragmentLoginInBinding

class LoginInFragment : Fragment(R.layout.fragment_login_in) {

    private val binding : FragmentLoginInBinding by lazy {
      FragmentLoginInBinding.inflate(layoutInflater)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        // Inflate the layout for this fragment

        return binding.root
    }

}