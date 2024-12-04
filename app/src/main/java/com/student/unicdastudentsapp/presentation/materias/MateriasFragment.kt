package com.student.unicdastudentsapp.presentation.materias

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentMateriasBinding
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class MateriasFragment : Fragment() {
    private var _binding: FragmentMateriasBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MateriasViewModel? =null
    var adapter: MateriaAdapter? = null

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
        if(!UserActiveUseCase.isUserActive()){
            onDestroyView()
        }
        val subjetViewModel =
            ViewModelProvider(this, MateriasViewModelFactory())
                .get(MateriasViewModel::class.java)

        val recyclerView = _binding!!.recyclerView
        recyclerView.setHasFixedSize(true)
        val context1 = requireContext()
        val linearLayoutManager = LinearLayoutManager(context1)
        recyclerView.layoutManager = linearLayoutManager
        var adapter : MateriaAdapter? = null
        subjetViewModel.selection() {
            if (it != null) {
                adapter = MateriaAdapter(it)
                recyclerView.adapter = adapter
                adapter?.setOnClickListener(object :
                    MateriaAdapter.OnClickListener {
                    override fun onClick(position: Int, model: InscriptionSubjects) {
                        launchFragmentB(model)
                    }
                })
            }
        }


    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
    private fun launchFragmentB(extra_grade: InscriptionSubjects) {
        UserActiveUseCase.setIns(extra_grade)
       findNavController().navigate(R.id.nav_grade)
    }

}