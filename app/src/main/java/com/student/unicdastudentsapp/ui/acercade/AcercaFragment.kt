package com.student.unicdastudentsapp.ui.acercade

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentAcercaBinding
import com.student.unicdastudentsapp.databinding.FragmentPerfilBinding
import com.student.unicdastudentsapp.ui.perfil.PerfilViewModel

class AcercaFragment : Fragment() {

    companion object {
        fun newInstance() = AcercaFragment()
    }
    private var _binding: FragmentAcercaBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private val viewModel: AcercaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel = viewModel
        _binding = FragmentAcercaBinding.inflate(inflater,container, false)
         val root: View = binding.root
        return root
    }


}