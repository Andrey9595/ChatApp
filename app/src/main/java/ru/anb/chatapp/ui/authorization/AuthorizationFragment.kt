package ru.anb.chatapp.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint
import ru.anb.chatapp.R
import ru.anb.chatapp.databinding.FragmentAuthorizationBinding

@AndroidEntryPoint
class AuthorizationFragment : Fragment() {

    private var _binding: FragmentAuthorizationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: AuthorizationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthorizationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendNumber.setOnClickListener{
            viewModel.sendPhone(binding.phoneNumber.text.toString())
        }
        binding.CheckCode.setOnClickListener{
            viewModel.checkCode(binding.password.text.toString(), binding.phoneNumber.text.toString())
        }
    }

}