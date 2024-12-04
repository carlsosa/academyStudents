package com.student.unicdastudentsapp.presentation.evento

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.use_case.EventUseCase

class EventViewModel(private val event: EventUseCase): ViewModel() {


    fun getCalendarYear() : String{
        return event.getCalendarYear()
    }

    fun descEvent(events: List<Event>, callback: (String?)->Unit){
       event.descEvent(events){
           callback(it)
       }
    }

    val noEvents: String = event.noEvents;
}