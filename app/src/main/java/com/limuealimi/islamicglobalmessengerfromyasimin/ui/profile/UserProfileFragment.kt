package com.limuealimi.islamicglobalmessengerfromyasimin.ui.profile

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.tabs.TabLayoutMediator
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.ui.home.ContactsAdapter
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentUserProfileBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.data.models.Contacts
import com.limuealimi.islamicglobalmessengerfromyasimin.ui.chats.ChatsFragment
import com.limuealimi.islamicglobalmessengerfromyasimin.ui.discover.DiscoverFragment
import com.limuealimi.islamicglobalmessengerfromyasimin.ui.records.RecordsFragment
import com.limuealimi.islamicglobalmessengerfromyasimin.ui.spams.SpamsFragment
import com.limuealimi.islamicglobalmessengerfromyasimin.ui.stories.StoriesFragment

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    private val binding by viewBinding(FragmentUserProfileBinding::bind)
    private lateinit var contactList: ArrayList<Contacts>
    private lateinit var contactsAdapter: ContactsAdapter
    private lateinit var userInterfacePagerAdapter: UserInterfacePagerAdapter
    private lateinit var fragmentList: ArrayList<Fragment>
    private var resultToChats: Int = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Use the Kotlin extension in the fragment-ktx artifact
        setFragmentResultListener("requestKey") { _, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val result = bundle.getInt("bundleKey")
            // Do something with the result
            if (result != -1) {
                resultToChats = result
                binding.userContainer.setBackgroundColor(resources.getColor(result))
            }
        }
    }

    override fun onResume() {
        super.onResume()
        binding.apply {
            contactsAdapter = ContactsAdapter(contactList)
            contactRv.adapter = contactsAdapter
            userContainer.setBackgroundColor(resources.getColor(resultToChats))
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadFragments()
        loadData()
        userInterfacePagerAdapter =
            UserInterfacePagerAdapter(this, fragmentList)
        contactsAdapter = ContactsAdapter(contactList)
        binding.apply {
            contactRv.adapter = contactsAdapter
            pager.adapter = userInterfacePagerAdapter
            TabLayoutMediator(tabLayout, pager) { tab, position ->
                when (position) {
                    0 -> {

                        tab.text = "Chats"
                    }
                    1 -> {
                        tab.text = "Stories"
                    }
                    2 -> {
                        tab.text = "Discover"
                    }
                    3 -> {
                        tab.text = "Records"
                    }
                    4 -> {
                        tab.text = "Spams"
                    }
                }
            }.attach()
        }
    }

    private fun loadData() {
        contactList = ArrayList()
        contactList.add(Contacts(R.drawable.man_profile, 25, "male", "Jojo", "991234567"))
        contactList.add(Contacts(R.drawable.women_profile, 22, "female", "Hano", "991234568"))
        contactList.add(Contacts(R.drawable.man_profile, 25, "male", "Peter", "991234569"))
        contactList.add(Contacts(R.drawable.man_profile, 25, "male", "Alex", "991234561"))
        contactList.add(Contacts(R.drawable.women_profile, 22, "female", "Miya", "991234562"))
        contactList.add(Contacts(R.drawable.man_profile, 25, "male", "Axel", "991234563"))
        contactList.add(Contacts(R.drawable.man_profile, 25, "male", "Adam", "991234564"))
        contactList.add(Contacts(R.drawable.women_profile, 20, "female", "Leyla", "991234565"))
        contactList.add(Contacts(R.drawable.man_profile, 25, "male", "Joseph", "991234566"))
    }

    private fun loadFragments() {
        fragmentList = ArrayList()
        fragmentList.add(0, ChatsFragment())
        fragmentList.add(1, StoriesFragment())
        fragmentList.add(2, DiscoverFragment())
        fragmentList.add(3, RecordsFragment())
        fragmentList.add(4, SpamsFragment())
    }
}