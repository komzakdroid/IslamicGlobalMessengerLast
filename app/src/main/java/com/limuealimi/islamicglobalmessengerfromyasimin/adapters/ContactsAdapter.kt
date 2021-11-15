package com.limuealimi.islamicglobalmessengerfromyasimin.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.ItemContactviewBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.models.Contacts

class ContactsAdapter(private val contactList: List<Contacts>) :
    RecyclerView.Adapter<ContactsAdapter.Vh>() {
    inner class Vh(private var itemContactviewBinding: ItemContactviewBinding) :
        RecyclerView.ViewHolder(itemContactviewBinding.root) {

        fun onBind(contacts: Contacts) {
            itemContactviewBinding.apply {
                contactImage.setImageResource(contacts.image)
                contactName.text = contacts.name
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemContactviewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(contactList[position])
    }

    override fun getItemCount(): Int {
        return contactList.size
    }
}