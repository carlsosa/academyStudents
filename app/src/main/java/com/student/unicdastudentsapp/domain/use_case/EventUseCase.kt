package com.student.unicdastudentsapp.domain.use_case

import com.applandeo.materialcalendarview.CalendarDay
import com.student.unicdastudentsapp.domain.interfaces.EventsRepository
import com.student.unicdastudentsapp.domain.model.Event

class EventUseCase(private val event: EventsRepository) {
    fun getCalendarYear() : String{
        return event.getCalendarYear()
    }

    fun descEvent(events: List<Event>, callback: (String?) -> Unit){
        var eventInfo = ""
        events.forEach {
            eventInfo = eventInfo + "\n" + it.event

        }
        var st = StringBuilder().append("Descripción del evento:")
            .append("\n")
            .append(eventInfo).toString()
       callback(st)
    }

    val noEvents: String = event.noEvents;

    fun getEvents(callback: (List<Event>?) -> Unit){
        event.getEvents { callback(it) }
    }

    fun getEventDays(callback: (List<CalendarDay>?) -> Unit){
        event.getEventDays { callback(it) }
    }

    fun findEventsByDate(cal: String, callback: (List<Event>?) -> Unit){
        event.findEventsByDate(cal){
            callback(it)
        }
    }


}