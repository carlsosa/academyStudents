package com.student.unicdastudentsapp.ui.notificaciones

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.student.unicdastudentsapp.R

class NotificacionesFragment : Fragment() {

    companion object {
        fun newInstance() = NotificacionesFragment()
    }

    private val viewModel: NotificacionesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // TODO: Use the ViewModel
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_notificaciones, container, false)
    }
}