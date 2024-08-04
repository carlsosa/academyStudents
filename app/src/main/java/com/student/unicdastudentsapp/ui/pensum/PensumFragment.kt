package com.student.unicdastudentsapp.ui.pensum

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.databinding.FragmentPensumBinding


class PensumFragment : Fragment() {

    private var _binding: FragmentPensumBinding? = null
    private val binding get() = _binding!!
    var index = 1;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pensumViewModel =
            ViewModelProvider(this).get(PensumViewModel::class.java)

        _binding = FragmentPensumBinding.inflate(inflater, container, false)
        val root: View = binding.root

        // set title
        val textView: TextView = binding.q1Txt
        pensumViewModel.studyField.observe(viewLifecycleOwner) {
            textView.text = it
        }

        val context = requireContext()
        setInitView(context, pensumViewModel, binding)

        var button = binding.btnAtras
        button.setOnClickListener(View.OnClickListener {
            if (index > 1) {
                index = index - 1;
                setView(context, pensumViewModel, index, binding)
            }
        })

        var button_next = binding.btnAlante
        button_next.setOnClickListener(View.OnClickListener {
            if (index < 6 && index >= 1) {
                index = index + 1;
                setView(context, pensumViewModel, index, binding)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setView(
        context: Context,
        pensumViewModel: PensumViewModel,
        index: Int,
        binding: FragmentPensumBinding
    ) {
        pensumViewModel.setView(context, pensumViewModel, index, binding)
    }

    fun setInitView(
        context: Context,
        pensumViewModel: PensumViewModel,
        binding: FragmentPensumBinding
    ) {
        pensumViewModel
            .setInitView(context, pensumViewModel, binding)

    }

}