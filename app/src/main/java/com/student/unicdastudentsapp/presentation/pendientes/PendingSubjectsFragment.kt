package com.student.unicdastudentsapp.presentation.pendientes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.databinding.FragmentPendingSubjectsBinding
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase


class PendingSubjectsFragment : Fragment() {

    private var _binding: FragmentPendingSubjectsBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       _binding = FragmentPendingSubjectsBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel =
            ViewModelProvider(this, PendientesViewModelFactory())
                .get(PendingSubjectsViewModel::class.java)

        if (UserActiveUseCase.isUserActive()) {

            val recyclerView = binding.recyclerViewPendings
            recyclerView.setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = linearLayoutManager
            viewModel.pendingSubjects() {
                if (it != null) {
                    recyclerView.adapter = PendingSubjectsAdapter(it)
                }
            }

        }
    }
}