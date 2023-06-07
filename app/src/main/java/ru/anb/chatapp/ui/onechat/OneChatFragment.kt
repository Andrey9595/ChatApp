package ru.anb.chatapp.ui.onechat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.anb.chatapp.databinding.FragmentOneChatBinding
import ru.anb.chatapp.ui.chat.ViewModelChat

private const val ARG_CHAT_ID = "getOwnChat"

@AndroidEntryPoint
class OneChatFragment : Fragment() {
    private val viewModel: OneChatViewModel by viewModels()
    private val args by navArgs<OneChatFragmentArgs>()
    private var chatId: Int? = null
    private var _binding: FragmentOneChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneChatBinding.inflate(layoutInflater, container, false)
//        chatId = arguments?.getInt(ARG_CHAT_ID)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        chatId = args.chatId
       binding.fragmentPost.chatName.text = chatId.toString()
        viewModel.getMessages(chatId!!)
    }
}