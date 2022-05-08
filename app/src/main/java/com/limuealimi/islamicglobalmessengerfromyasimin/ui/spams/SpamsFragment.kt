package com.limuealimi.islamicglobalmessengerfromyasimin.ui.spams

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.limuealimi.islamicglobalmessengerfromyasimin.R

class SpamsFragment : Fragment(R.layout.fragment_spams) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_spams, container, false)
    }
}