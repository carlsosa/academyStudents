package com.student.unicdastudentsapp.presentation.evento

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.ActivityEventBinding
import com.student.unicdastudentsapp.presentation.data.InitRepository
import com.student.unicdastudentsapp.presentation.data.model.Event


class EventActivity : AppCompatActivity() {


    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       val viewModel =  InitRepository()
        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = binding.eventTitle
        val date = binding.eventDate
        val desc = binding.eventDesc
        val events = intent.extras?.get("EXTRA_EVENT") as List<Event>
        title.text = viewModel.getCalendarYear()
        if (events.isNotEmpty()) {
            desc.text =   viewModel.descEvent(events)
            date.text = events[0].selfCalendar
            binding.eventImage.setImageResource(R.drawable.dominico2)
        } else {
            title.text = viewModel.noEvents
        }

    }




}