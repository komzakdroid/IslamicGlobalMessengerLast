package com.limuealimi.islamicglobalmessengerfromyasimin.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentChatsBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentUserProfileBinding
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class ChatsFragment : Fragment(R.layout.fragment_chats) {
    private val binding by viewBinding(FragmentChatsBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}