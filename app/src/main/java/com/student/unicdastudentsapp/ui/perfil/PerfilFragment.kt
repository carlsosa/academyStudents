package com.student.unicdastudentsapp.ui.perfil

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.student.unicdastudentsapp.databinding.FragmentPerfilBinding
import com.student.unicdastudentsapp.ui.data.model.UserActive

class PerfilFragment : Fragment() {

    private var _binding: FragmentPerfilBinding? = null

    private val binding get() = _binding!!
    private val viewModel: PerfilViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPerfilBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!UserActive.isUserActive()) {
            onDestroyView()
        }
        val perfilViewModel = viewModel
        init(_binding!!, perfilViewModel)

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   private fun init(binding1: FragmentPerfilBinding, vm: PerfilViewModel) {
        vm.init(binding1)
    }
}