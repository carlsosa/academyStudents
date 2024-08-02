package com.student.unicdastudentsapp.ui.evento

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.ActivityEventBinding
import com.student.unicdastudentsapp.ui.data.model.Event
import java.util.Calendar


class EventActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEventBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityEventBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val title = binding.eventTitle
        val date = binding.eventDate
        val desc = binding.eventDesc
        val img  = binding.eventImage.setImageResource(R.drawable.dominico2)
        val events = intent.extras?.get("EXTRA_EVENT") as List<Event>
        title.text = "CALENDARIO ADMINISTRATIVO " +
                Calendar.getInstance().get(Calendar.YEAR)
        var eventInfo : String? = ""
        if(events.isNotEmpty()) {
            date.text = events.get(0).self
            events.forEach {
                eventInfo = eventInfo +"\n" + it.event

            }
            desc.text="Descripción del evento:" +"\n" +eventInfo

        }else{
            title.text = "No hay eventos";
        }

    }


}