package com.student.unicdastudentsapp.presentation.grades

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.databinding.FragmentGradeBinding
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class GradeFragment : Fragment() {


    private var _binding: FragmentGradeBinding? = null
    private val binding get() = _binding!!
    private var viewModel: GradeViewModel? = null
    private var subject : InscriptionSubjects? = null


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGradeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        subject = UserActiveUseCase.getIns()
        val title = binding.gradeTitle
        val desc = binding.gradeDesc
        viewModel =  ViewModelProvider(this, GradeViewModelFactory())
            .get(GradeViewModel::class.java)
        if(subject != null) {
            viewModel!!.calification(subject!!) {
                title.text = subject!!.name
                desc.text = it
            }
        }
    }
}