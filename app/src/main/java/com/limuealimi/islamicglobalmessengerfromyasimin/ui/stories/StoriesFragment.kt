package com.limuealimi.islamicglobalmessengerfromyasimin.ui.stories

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.limuealimi.islamicglobalmessengerfromyasimin.R

class StoriesFragment : Fragment(R.layout.fragment_stories) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_stories, container, false)
    }
}