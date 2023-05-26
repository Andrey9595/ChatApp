package ru.anb.chatapp.ui.onechat

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dagger.hilt.android.AndroidEntryPoint
import ru.anb.chatapp.databinding.FragmentOneChatBinding

@AndroidEntryPoint
class OneChatFragment : Fragment() {

    private var _binding: FragmentOneChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentOneChatBinding.inflate(layoutInflater, container, false)
        return binding.root
    }
}