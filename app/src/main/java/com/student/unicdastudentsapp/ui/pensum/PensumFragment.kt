package com.student.unicdastudentsapp.ui.pensum

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.student.unicdastudentsapp.databinding.FragmentPensumBinding


class PensumFragment : Fragment() {

    private var _binding: FragmentPensumBinding? = null
    private val viewModel: PensumViewModel by viewModels()
    private val minIndex: Int = 1
    private val maxIndex: Int = 6

    private val binding get() = _binding!!
    private var index =  1
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPensumBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pensumViewModel =
            viewModel
        // set title
        val textView: TextView = binding.q1Txt
        pensumViewModel.studyField.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val context = requireContext()
        setInitView(context, pensumViewModel, binding)

        val button = binding.btnAtras
        button.setOnClickListener(View.OnClickListener {
            if (index > minIndex) {
                index -= minIndex
                setView(context, pensumViewModel, index, binding)
            }
        })

        val buttonNext = binding.btnAlante
        buttonNext.setOnClickListener(View.OnClickListener {
            if (index in minIndex..<maxIndex) {
                index += minIndex
                setView(context, pensumViewModel, index, binding)
            }
        })

    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

   private fun setView(
        context: Context,
        pensumViewModel: PensumViewModel,
        index: Int,
        binding: FragmentPensumBinding
    ) {
        pensumViewModel.setView(context, index, binding)
    }

   private fun setInitView(
        context: Context,
        pensumViewModel: PensumViewModel,
        binding: FragmentPensumBinding
    ) {
        pensumViewModel
            .setInitView(context, binding)

    }

}