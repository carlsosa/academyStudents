package com.student.unicdastudentsapp.ui.acercade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.student.unicdastudentsapp.databinding.FragmentAcercaBinding

class AcercaFragment : Fragment() {

    companion object {
        fun newInstance() = AcercaFragment()
    }
    private var _binding: FragmentAcercaBinding? = null

    private val binding get() = _binding!!
    private val viewModel: AcercaViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
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