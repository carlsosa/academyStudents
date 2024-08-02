package com.student.unicdastudentsapp.ui.calendario

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.applandeo.materialcalendarview.CalendarDay
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.ui.data.model.Event
import java.util.Calendar

 class CalendarioViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hello World Unicda"
    }
    val text: LiveData<String> = _text
    var events = mutableListOf<Event>();

    fun getEventDays() : List<CalendarDay>{

        // set calendar
        var calendarDays = mutableListOf<CalendarDay>();

        var calendar = Calendar.getInstance();
        calendar.set(2024,8-1, 8)
        var calendarDay =  CalendarDay(calendar);
        calendarDays.add(calendarDay);
        events.add(Event(calendarDay.calendar.time.date.toString(),"Examen Parcial",calendarDay.calendar.time.toString()))

        var cal1 = Calendar.getInstance();
        cal1.set(2024,8-1, 3)
        var calendarDay1 =  CalendarDay(cal1);
        events.add(Event(calendarDay1.calendar.time.date.toString(),"Examen Parcial 2",calendarDay1.calendar.time.toString()))
        calendarDays.add(calendarDay1);

        var cal2 = Calendar.getInstance();
        cal2.set(2024,8-1, 15)
        var calendarDay2 =  CalendarDay(cal2);
        calendarDays.add(calendarDay2);
        events.add(Event(calendarDay2.calendar.time.date.toString(),"Examen Final",calendarDay2.calendar.time.toString()))

        var cal3 = Calendar.getInstance();
        cal3.set(2024,8-1, 15)
        var calendarDay3 =  CalendarDay(cal2);
        events.add(Event(calendarDay3.calendar.time.date.toString(),"Fin Cuatrimestre",calendarDay3.calendar.time.toString()))

        calendarDays.add(calendarDay3);

        calendarDays.forEach {
            it.imageResource = R.drawable.calendar
            it.labelColor = R.color.teal_700
        }
        return calendarDays;
    }

   fun findEventsByDate(cal: String): List<Event> {
        return events.filter { it.date == cal }
   }
}