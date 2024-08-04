package com.student.unicdastudentsapp.ui.materias

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.databinding.FragmentMateriasBinding
import com.student.unicdastudentsapp.ui.data.model.Subjets
import com.student.unicdastudentsapp.ui.data.model.UserActive
import com.student.unicdastudentsapp.ui.grades.GradeActivity
import java.io.Serializable

class MateriasFragment : Fragment() {
    private var _binding: FragmentMateriasBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MateriasViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMateriasBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!UserActive.isUserActive()){
            onDestroyView()
        }
        val subjetViewModel =
           viewModel

        val recyclerView = _binding!!.recyclerView
        recyclerView.setHasFixedSize(true)
        val context1 = requireContext()
        val linearLayoutManager = LinearLayoutManager(context1)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = MateriaAdapter(subjetViewModel.qt1)
        recyclerView.adapter = adapter


        adapter.setOnClickListener(object :
            MateriaAdapter.OnClickListener {
            override fun onClick(position: Int, model: Subjets) {
                val intent = Intent(context, GradeActivity::class.java)
                intent.putExtra("EXTRA_GRADE", model as Serializable)
                startActivity(intent)
            }
        })
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }

}