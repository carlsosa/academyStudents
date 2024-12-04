package com.student.unicdastudentsapp.presentation.calendario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applandeo.materialcalendarview.CalendarDay
import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.use_case.EventUseCase

class CalendarioViewModel(private val eventUseCase: EventUseCase) : ViewModel() {


    private val _text = MutableLiveData<String>().apply {
        value = "Hello World Unicda"
    }
    val text: LiveData<String> = _text
    val eventDays_ = MutableLiveData<List<CalendarDay>>()

    fun getEventDays(callback: (List<CalendarDay>?)-> Unit)  {
        eventUseCase.getEventDays(){
             eventDays_.postValue(it)
       }

    }

   fun findEventsByDate(cal: String, callback: (List<Event>?) -> Unit)  {
       eventUseCase.findEventsByDate(cal){
           callback(it)
        }
   }

}