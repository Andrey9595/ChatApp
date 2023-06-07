package ru.anb.chatapp.ui.onechat

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import ru.anb.chatapp.adapter.MessageAdapter
import ru.anb.chatapp.databinding.FragmentOneChatBinding


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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MessageAdapter()
        binding.recyclerView.adapter = adapter
        chatId = args.chatId
        val messagelist = viewModel.getMessages(chatId!!)?.messages
        messagelist?.let {
            adapter.setData(it)
        }
    }
}