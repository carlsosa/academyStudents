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

    fun getEventDays(callback: (List<CalendarDay>?)-> Unit)  {
        EventsRepository().getEventDays(){
              callback(it)
       }

    }

   fun findEventsByDate(cal: String, callback: (List<Event>?) -> Unit)  {
        EventsRepository().findEventsByDate(cal){
            callback(it)
        }
   }

}