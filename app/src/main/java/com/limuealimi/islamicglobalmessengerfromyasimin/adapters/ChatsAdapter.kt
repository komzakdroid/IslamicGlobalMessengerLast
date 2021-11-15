package com.limuealimi.islamicglobalmessengerfromyasimin.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.limuealimi.islamicglobalmessengerfromyasimin.R
import com.limuealimi.islamicglobalmessengerfromyasimin.databinding.ItemChatsBinding
import com.limuealimi.islamicglobalmessengerfromyasimin.models.Chats

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

                if (accountWhenOnline.text == "online") {
                    dotAccountStatus.setBackgroundColor(R.color.notificationColor.toInt())
                } else if (accountWhenOnline.text == "offline" && chats.contacts.gender == "male") {
                    dotAccountStatus.setBackgroundColor(R.color.manColorOne.toInt())
                } else if (accountWhenOnline.text == "offline" && chats.contacts.gender ==  "female") {
                    dotAccountStatus.setBackgroundColor(R.color.womanColorOne.toInt())
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