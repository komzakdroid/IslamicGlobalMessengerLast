package com.limuealimi.islamicglobalmessengerfromyasimin.ui

import android.os.Bundle
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.setFragmentResultListener
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.adapters.ChatsAdapter
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.FragmentChatsBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.models.Chats
import com.limuealimi.islamicglobalmessengerfromyasimin.models.Contacts
import com.zhuinden.fragmentviewbindingdelegatekt.viewBinding

class ChatsFragment : Fragment(R.layout.fragment_chats) {

    lateinit var binding: FragmentChatsBinding
    private lateinit var contactList: ArrayList<Contacts>
    private lateinit var chatsList: ArrayList<Chats>
    private lateinit var chatsAdapter: ChatsAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Use the Kotlin extension in the fragment-ktx artifact
        setFragmentResultListener("requestToChatsKey") { _, bundle ->
            // We use a String here, but any type that can be put in a Bundle is supported
            val result = bundle.getInt("bundleToChatsKey")
            // Do something with the result
            if (result != -1) {
                binding.container.setBackgroundColor(resources.getColor(result))
            }
            loadDataContact()
            loadData()
            chatsAdapter = ChatsAdapter(chatsList)
            binding.apply {
                chatsRv.adapter = chatsAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()
        loadDataContact()
        loadData()
        chatsAdapter = ChatsAdapter(chatsList)
        binding.apply {
            chatsRv.adapter = chatsAdapter
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentChatsBinding.inflate(inflater, container, false)
        loadDataContact()
        loadData()
        chatsAdapter = ChatsAdapter(chatsList)
        binding.apply {
            chatsRv.adapter = chatsAdapter
        }

        loadDataContact()
        loadData()
        chatsAdapter = ChatsAdapter(chatsList)
        binding.apply {
            chatsRv.adapter = chatsAdapter
        }
        return binding.root

    }

    override fun onPause() {
        super.onPause()
        loadDataContact()
        loadData()
        chatsAdapter = ChatsAdapter(chatsList)
        binding.apply {
            chatsRv.adapter = chatsAdapter
        }
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadDataContact()
        loadData()
        chatsAdapter = ChatsAdapter(chatsList)
        binding.apply {
            chatsRv.adapter = chatsAdapter
        }
    }

    private fun loadDataContact() {
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

    private fun loadData() {
        chatsList = ArrayList()
        chatsList.add(
            Chats(
                contactList[0],
                R.drawable.mpfourtype,
                "seen",
                "mazzami silaga",
                "online",
                R.color.notificationColor,
                1
            )
        )
        chatsList.add(
            Chats(
                contactList[1],
                R.drawable.csvtype,
                "seen",
                "mazzami silaga",
                "2 soat oldin",
                R.color.notificationColor,
                2
            )
        )
        chatsList.add(
            Chats(
                contactList[2],
                R.drawable.avitype,
                "seen",
                "mazzami silaga",
                "online",
                R.color.notificationColor,
                3
            )
        )
        chatsList.add(
            Chats(
                contactList[3],
                R.drawable.pdftype,
                "seen",
                "mazzami silaga",
                "1 soat oldin",
                R.color.notificationColor,
                4
            )
        )
        chatsList.add(
            Chats(
                contactList[4],
                R.drawable.documenttype,
                "seen",
                "mazzami silaga",
                "online",
                R.color.notificationColor,
                5
            )
        )
        chatsList.add(
            Chats(
                contactList[5],
                R.drawable.csvtype,
                "seen",
                "mazzami silaga",
                "10 daqiqa oldin",
                R.color.notificationColor,
                6
            )
        )
        chatsList.add(
            Chats(
                contactList[6],
                R.drawable.xlstype,
                "seen",
                "mazzami silaga",
                "online",
                R.color.notificationColor,
                7
            )
        )
        chatsList.add(
            Chats(
                contactList[7],
                R.drawable.ppttype,
                "seen",
                "mazzami silaga",
                "3 soat oldin",
                R.color.notificationColor,
                8
            )
        )
        chatsList.add(
            Chats(
                contactList[8],
                R.drawable.giftype,
                "seen",
                "mazzami silaga",
                "online",
                R.color.notificationColor,
                9
            )
        )
    }
}