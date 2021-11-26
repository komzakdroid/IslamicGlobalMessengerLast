package com.limuealimi.islamicglobalmessengerfromyasimin.adapters

import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.limuealimi.islamicglobalmessengerfromyasimin.ui.*

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