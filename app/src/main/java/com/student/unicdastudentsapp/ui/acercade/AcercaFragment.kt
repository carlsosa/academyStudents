package com.student.unicdastudentsapp.ui.acercade

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.student.unicdastudentsapp.databinding.FragmentAcercaBinding
import com.student.unicdastudentsapp.ui.data.model.UserActive

class AcercaFragment : Fragment() {

    companion object {
        fun newInstance() = AcercaFragment()
    }
    private var _binding: FragmentAcercaBinding? = null

    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAcercaBinding.inflate(inflater,container, false)
         val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!UserActive.isUserActive()){
            onDestroyView()
        }
    }
    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }



}