package com.student.unicdastudentsapp.domain.interfaces

import com.applandeo.materialcalendarview.CalendarDay
import com.student.unicdastudentsapp.domain.model.Event

interface EventsRepository {
    val noEvents: String
    fun getEvents(callback: (List<Event>?) -> Unit)
    fun getEventDays(callback: (List<CalendarDay>?) -> Unit)
    fun findEventsByDate(cal: String, callback: (List<Event>?) -> Unit)
    fun getCalendarYear(): String
    fun descEvent(events: List<Event>): String
}