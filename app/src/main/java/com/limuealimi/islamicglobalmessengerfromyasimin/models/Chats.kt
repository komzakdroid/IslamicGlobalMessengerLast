package com.limuealimi.islamicglobalmessengerfromyasimin.models

import android.graphics.Color

data class Chats(
    val contacts: Contacts,
    val fileTypeImage: Int,
    val messageSeenStatus: String,
    val lastMessage: String,
    val lastSeen: String,
    val notificationLayoutColor: Color,
    val unReadMessagesCount: Int
)
