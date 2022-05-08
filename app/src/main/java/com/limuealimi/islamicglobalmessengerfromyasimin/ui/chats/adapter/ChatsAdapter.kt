package com.limuealimi.islamicglobalmessengerfromyasimin.ui.chats.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.ItemChatsBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.data.models.Chats

class ChatsAdapter(private val chatsList: List<Chats>) : RecyclerView.Adapter<ChatsAdapter.Vh>() {
    inner class Vh(private var itemChatsBinding: ItemChatsBinding) :
        RecyclerView.ViewHolder(itemChatsBinding.root) {
        fun onBind(chats: Chats) {
            itemChatsBinding.apply {
                chatAccountImage.setImageResource(chats.contacts.image)
                chatAccountUserName.text = chats.contacts.name
                messageFiletype.setImageResource(chats.fileTypeImage)
                messageIsStatus.text = chats.messageSeenStatus
                accountWhenOnline.text = chats.lastSeen
                lastMessageText.text = chats.lastMessage
                unreadMessagesCount.text = chats.unReadMessagesCount.toString()

                if (chats.contacts.gender == "male") {
                    itemChatsLayout.setBackgroundColor(Color.parseColor("#4E426D"))
                } else if (chats.contacts.gender == "female") {
                    itemChatsLayout.setBackgroundColor(Color.parseColor("#FFADDE"))
                }

                if (accountWhenOnline.text == "online") {
                    dotAccountStatus.setCardBackgroundColor(Color.parseColor("#57BECF"))
                } else if (accountWhenOnline.text != "online" && chats.contacts.gender == "male") {
                    dotAccountStatus.setCardBackgroundColor(Color.parseColor("#4E426D"))
                } else if (accountWhenOnline.text != "online" && chats.contacts.gender == "female") {
                    dotAccountStatus.setCardBackgroundColor(Color.parseColor("#FFADDE"))
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(
            ItemChatsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(chatsList[position])
    }

    override fun getItemCount(): Int {
        return chatsList.size
    }
}