package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.model.Event
import java.util.Calendar

class EventUseCases {
    fun getCalendarYear() : String{
        return StringBuilder().append("CALENDARIO ADMINISTRATIVO ")
            .append(Calendar.getInstance().get(Calendar.YEAR)).toString()
    }

    fun descEvent(events: List<Event>) : String{
        var eventInfo = ""
        events.forEach {
            eventInfo = eventInfo + "\n" + it.event

        }
        var st = StringBuilder().append("Descripción del evento:")
            .append("\n")
            .append(eventInfo).toString()
        return st;
    }
}