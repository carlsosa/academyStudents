package com.student.unicdastudentsapp.ui.notificaciones

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.databinding.FragmentNotificacionesBinding
import com.student.unicdastudentsapp.ui.data.model.News
import com.student.unicdastudentsapp.ui.data.model.UserActive


class NotificacionesFragment : Fragment() {

    companion object {
        fun newInstance() = NotificacionesFragment()
    }

    private var _binding: FragmentNotificacionesBinding? = null
    private val binding get() = _binding!!

    private val viewModel: NotificacionesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentNotificacionesBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(!UserActive.isUserActive()){
            onDestroyView()
        }
        val viewModel1 =
            viewModel
        val recyclerView = _binding!!.recyclerViewNews
        recyclerView.setHasFixedSize(true)
        val context = requireContext()
        val linearLayoutManager = LinearLayoutManager(context)
        recyclerView.layoutManager = linearLayoutManager
        val adapter = NotificacionesAdapter(viewModel1.n1)
        recyclerView.adapter = adapter
        adapter.setOnClickListener(object : NotificacionesAdapter.OnClickListener {
            override fun onClick(position: Int, model: News) {
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(model.link))
                startActivity(browserIntent)
            }

        })
    }
    override fun onDestroyView() {

        super.onDestroyView()
        _binding = null
    }

}