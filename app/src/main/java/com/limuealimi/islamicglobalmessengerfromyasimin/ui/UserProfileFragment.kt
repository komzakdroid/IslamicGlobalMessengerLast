package com.limuealimi.islamicglobalmessengerfromyasimin.ui

import android.os.Bundle
import android.view.View
import android.widget.SeekBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.recyclerview.widget.RecyclerView
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.adapters.ContactsAdapter
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentUserProfileBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.models.Contacts
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class UserProfileFragment : Fragment(R.layout.fragment_user_profile) {

    private val binding by viewBinding(FragmentUserProfileBinding::bind)
    private lateinit var contactList: ArrayList<Contacts>
    private lateinit var contactsAdapter: ContactsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Use the Kotlin extension in the fragment-ktx artifact
        setFragmentResultListener("requestKey") { _, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val result = bundle.getInt("bundleKey")
            // Do something with the result
            if (result != -1) {
                binding.userContainer.setBackgroundColor(resources.getColor(result))
                binding.apply {

                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //setRecyclerViewItemTouchListener()
        loadData()
        contactsAdapter = ContactsAdapter(contactList)
        binding.apply {
            contactRv.adapter = contactsAdapter

            contactRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
                override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                    super.onScrollStateChanged(recyclerView, newState)

                }

                override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                    super.onScrolled(recyclerView, dx, dy)

                }
            })

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
}