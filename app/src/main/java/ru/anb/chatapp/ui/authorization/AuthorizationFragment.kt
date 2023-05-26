package ru.anb.chatapp.ui.authorization

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.anb.chatapp.R
import ru.anb.chatapp.databinding.FragmentAuthorizationBinding
import ru.anb.chatapp.models.LoadState

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
        binding.sendNumber.setOnClickListener {
            viewModel.sendPhone(binding.phoneNumber.text.toString())
        }
        binding.CheckCode.setOnClickListener {
            viewModel.checkCode(
                binding.phoneNumber.text.toString(),
                binding.password.text.toString()
            )
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.authState.collect {
                    if (it.checkLoadState is LoadState.UserIsExist)
                        findNavController().navigate(R.id.action_authorizationFragment_to_chatFragment)
                    if (it.checkLoadState is LoadState.UserIsMotExist)
                        findNavController().navigate(R.id.action_authorizationFragment_to_registrationFragment)
                }
            }
        }
    }

}