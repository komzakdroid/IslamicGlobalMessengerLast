package com.limuealimi.islamicglobalmessengerfromyasimin.data.models

data class Chats(
    val contacts: Contacts,
    val fileTypeImage: Int,
    val messageSeenStatus: String,
    val lastMessage: String,
    val lastSeen: String,
    val notificationLayoutColor: Int,
    val unReadMessagesCount: Int
)
