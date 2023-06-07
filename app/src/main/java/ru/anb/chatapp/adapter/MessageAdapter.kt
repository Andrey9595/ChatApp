package ru.anb.chatapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.viewbinding.ViewBinding
import ru.anb.chatapp.data.Message
import ru.anb.chatapp.data.MessageType
import ru.anb.chatapp.databinding.IncomingMessageBinding
import ru.anb.chatapp.databinding.OutgouingMessageBinding

class MessageAdapter() : RecyclerView.Adapter<MessageAdapter.MessageViewHolder>() {

    class MessageViewHolder(val binding: ViewBinding) : RecyclerView.ViewHolder(binding.root)

    private var messages: List<Message> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MessageViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            MessageType.INCOMING.ordinal -> {
                MessageViewHolder(IncomingMessageBinding.inflate(inflater))
            }
            else -> MessageViewHolder(OutgouingMessageBinding.inflate(inflater))
        }
    }

    override fun onBindViewHolder(holder: MessageViewHolder, position: Int) {
      val item = messages[position]
        when(item.type){
            MessageType.INCOMING -> (holder.binding as IncomingMessageBinding).text.text = item.text
            else -> (holder.binding as OutgouingMessageBinding).text.text = item.text
        }
    }

    override fun getItemCount() = messages.size



    override fun getItemViewType(position: Int): Int {
        return messages[position].type.ordinal
    }

    fun setData(data: List<Message>){
        messages = data
    }

}