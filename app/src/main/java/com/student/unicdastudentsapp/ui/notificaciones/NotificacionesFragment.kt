package com.student.unicdastudentsapp.ui.notificaciones

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentNotificacionesBinding


class NotificacionesFragment : Fragment() {

    companion object {
        fun newInstance() = NotificacionesFragment()
    }
    private var _binding: FragmentNotificacionesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NotificacionesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val viewModel1 =
            ViewModelProvider(this).get(NotificacionesViewModel::class.java)
        _binding = FragmentNotificacionesBinding.inflate(inflater, container, false)

        val recyclerView = _binding!!.recyclerViewNews
        recyclerView.setHasFixedSize(true)
        val context = requireContext()
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = NotificacionesAdapter(viewModel1.n1)
        recyclerView.adapter = adapter

        val root: View = binding.root
        return root
    }
}