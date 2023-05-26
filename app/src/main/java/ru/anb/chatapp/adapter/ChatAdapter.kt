package ru.anb.chatapp.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.anb.chatapp.databinding.ItemChatBinding
import ru.anb.chatapp.models.chat.ChatModel

class ChatAdapter() : RecyclerView.Adapter<ChatAdapter.ChatViewHolder>() {

    class ChatViewHolder(val binding: ItemChatBinding) : RecyclerView.ViewHolder(binding.root)

    private var chats: List<ChatModel> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ChatViewHolder {
        return ChatViewHolder(
            ItemChatBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ChatViewHolder, position: Int) {
        val item = chats[position]
        with(holder.binding) {
            chatName.text = item.chatMane
            lastMessage.text = item.lastMessage
        }
    }

    override fun getItemCount() = chats.size

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: List<ChatModel>) {
        chats = data
        notifyDataSetChanged()
    }
}