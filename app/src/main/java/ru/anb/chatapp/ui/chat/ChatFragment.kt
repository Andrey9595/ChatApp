package ru.anb.chatapp.ui.chat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import ru.anb.chatapp.R
import ru.anb.chatapp.adapter.ChatAdapter
import ru.anb.chatapp.databinding.FragmentChatBinding

@AndroidEntryPoint
class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!
    private val viewModel: ViewModelChat by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentChatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = ChatAdapter(onChatClick = {getOneChatFragment(it)})
        binding.recyclerView.adapter = adapter
        val chats = viewModel.getChatList()
        adapter.setData(chats)
        goToProfile()
    }

    private fun goToProfile(){
        binding.goToProfile.setOnClickListener {
            findNavController().navigate(R.id.action_chatFragment_to_profileFragment)
        }
    }

    private fun getOneChatFragment(id: Int){
        val action = ChatFragmentDirections.actionChatFragmentToOneChatFragment(id)
        findNavController().navigate(action)
    }
}