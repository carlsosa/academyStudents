package com.student.unicdastudentsapp.presentation.evento

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentEventBinding
import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase


class EventFragment : Fragment() {
    private var events: List<Event>? = null
    private var _binding: FragmentEventBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentEventBinding.inflate(inflater, container, false)

        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        events = UserActiveUseCase.getUserEvents()
        val viewModel =
            ViewModelProvider(this, EventsViewModelFactory())
                .get(EventViewModel::class.java)
        // Inflate the layout for this fragment
        val title = binding.eventTitle
        val date = binding.eventDate
        val desc = binding.eventDesc
        title.text = viewModel.getCalendarYear()
        if (events!= null && events!!.isNotEmpty()) {
            viewModel.descEvent(events!!) {
                desc.text = it
                    date.text = events!![0].selfCalendar
                binding.eventImage.setImageResource(R.drawable.dominico2)
            }
        } else {
            title.text = viewModel.noEvents
        }
    }
}