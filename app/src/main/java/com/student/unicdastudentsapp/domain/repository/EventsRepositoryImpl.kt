package com.student.unicdastudentsapp.domain.repository

import com.applandeo.materialcalendarview.CalendarDay
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.domain.interfaces.EventsRepository
import com.student.unicdastudentsapp.domain.model.Event
import java.util.Calendar

class EventsRepositoryImpl : EventsRepository {

    companion object {
        private const val COLNAME = "events";
    }

    override val noEvents = StringBuilder().append("No hay eventos").toString()

    override fun getEvents(callback: (List<Event>?) -> Unit) {
        val db = FirebaseFirestore.getInstance()
        val collection = db.collection(COLNAME);
        collection.whereEqualTo("active", true)
            .orderBy("date", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                val events = mutableListOf<Event>()
                if (!documents.isEmpty) {
                    for (document in documents) {
                        val ps = document.toObject(Event::class.java)
                        events.add(ps);
                    }
                    println("Se encontro eventos ")
                    callback(events);
                } else {
                    println("No se encontro eventos ")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }


    override fun getEventDays(callback: (List<CalendarDay>?) -> Unit) {

        // set calendar
        val calendarDays = mutableListOf<CalendarDay>()
        getEvents() { docs ->

            if (docs != null) {
                for (c in docs) {
                    val calendar = Calendar.getInstance()
                    calendar.set(c.year, c.month - 1, c.day);
                    val calendarDay = CalendarDay(calendar)
                    calendarDay.imageResource = R.drawable.calendar
                    calendarDay.labelColor = R.color.teal_700
                    calendarDays.add(calendarDay)


                }
                callback(calendarDays)
            }
        }
        return callback(emptyList())
    }

    override fun findEventsByDate(cal: String, callback: (List<Event>?) -> Unit) {
        var events = mutableListOf<Event>()
        getEvents() { docs ->

            if (docs != null) {
                for (c in docs) {
                    val calendar = Calendar.getInstance()
                    calendar.set(c.year, c.month - 1, c.day);
                    val calendarDay = CalendarDay(calendar)
                    if (calendarDay.calendar.time.date.toString() == cal) {
                        events.add(
                            Event(
                                calendarDay.calendar.time.date.toString(),
                                c.event,
                                calendarDay.calendar.time.toString()
                            )
                        )
                    }

                }
                callback(events)
            }
        }
        callback(emptyList())
    }

    override fun getCalendarYear(): String {
        return StringBuilder().append("CALENDARIO ADMINISTRATIVO ")
            .append(Calendar.getInstance().get(Calendar.YEAR)).toString()
    }

    override fun descEvent(events: List<Event>): String {
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