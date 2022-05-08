package com.limuealimi.islamicglobalmessengerfromyasimin.ui.profile

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

class UserInterfacePagerAdapter(
    private val fm: Fragment,
    private val fragments: List<Fragment>,
) :
    FragmentStateAdapter(fm) {
    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}