package ru.anb.chatapp.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import ru.anb.chatapp.R
import ru.anb.chatapp.databinding.FragmentRegistrationBinding
import ru.anb.chatapp.models.LoadState

@AndroidEntryPoint
class RegistrationFragment : Fragment() {

    private var _binding: FragmentRegistrationBinding? = null
    private val binding get() = _binding!!
    private val viewModel: RegistrationViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRegistrationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.sendData.setOnClickListener {
            viewModel.registration(phone = binding.addPhone.text.toString(), name = binding.addName.text.toString(), username = binding.addUsername.text.toString())
        }
        viewLifecycleOwner.lifecycleScope.launch{
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.registrState.collect{
                    if (it is LoadState.Success)
                        findNavController().navigate(R.id.action_registrationFragment_to_chatFragment)
                    if (it is LoadState.Error)
                        Toast.makeText(requireContext(), getString(it.error), Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}