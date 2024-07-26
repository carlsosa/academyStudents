package com.student.unicdastudentsapp.ui.materias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.databinding.FragmentMateriasBinding

class MateriasFragment : Fragment() {
    private var _binding: FragmentMateriasBinding? = null
    private val binding get() = _binding!!
    companion object {
        fun newInstance() = MateriasFragment()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val subjetViewModel =
            ViewModelProvider(this).get(MateriasViewModel::class.java)
        _binding = FragmentMateriasBinding.inflate(inflater, container, false)

        val recyclerView = _binding!!.recyclerView
        recyclerView.setHasFixedSize(true)
        val context = requireContext()
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = MateriaAdapter(subjetViewModel.qt1)
        recyclerView.adapter = adapter

        val root: View = binding.root
        return root
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}