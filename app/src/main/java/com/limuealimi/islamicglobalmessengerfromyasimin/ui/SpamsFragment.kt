package com.limuealimi.islamicglobalmessengerfromyasimin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentSpamsBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentUserProfileBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class SpamsFragment : Fragment(R.layout.fragment_spams) {
    private val binding by viewBinding(FragmentSpamsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

}