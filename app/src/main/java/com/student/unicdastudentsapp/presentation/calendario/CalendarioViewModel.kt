package com.student.unicdastudentsapp.presentation.calendario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applandeo.materialcalendarview.CalendarDay
import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.repository.EventsRepository

class CalendarioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hello World Unicda"
    }
    val text: LiveData<String> = _text


    fun getEventDays() : List<CalendarDay>{
       return EventsRepository().getEventDays();
    }

   fun findEventsByDate(cal: String): List<Event> {
        return EventsRepository().findEventsByDate(cal)
   }

}