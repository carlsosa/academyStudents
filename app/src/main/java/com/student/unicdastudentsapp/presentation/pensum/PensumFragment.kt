package com.student.unicdastudentsapp.presentation.pensum

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.databinding.FragmentPensumBinding
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase


class PensumFragment : Fragment() {

    private var _binding: FragmentPensumBinding? = null
    private val viewModel: PensumViewModel ?  =null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPensumBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override  fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(UserActiveUseCase.isUserActive()) {

            val pensumViewModel =
                ViewModelProvider(this, PensumViewModelFactory())
                    .get(PensumViewModel::class.java)

            // set title
            val textView: TextView = binding.q1Txt
            val subtitle: TextView = binding.q1Label
            subtitle.text = "PERIODO | CURSO | CREDITOS";
            pensumViewModel.studyField.observe(viewLifecycleOwner) {
                textView.text = it
            }
            val context = requireContext()
            val recyclerView = binding.recyclerViewPensum
            recyclerView.setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(context)
            recyclerView.layoutManager = linearLayoutManager
            pensumViewModel.subjects() {
                if (it != null) {
                    val adapter = PensumSubjectsAdapter(it)
                    recyclerView.adapter = adapter
                }
            }
        }
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}