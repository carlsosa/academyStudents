package com.student.unicdastudentsapp.domain.repository

import com.applandeo.materialcalendarview.CalendarDay
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.use_case.EventUseCases
import java.util.Calendar

class EventsRepository {

    companion object {
        private const val COLNAME = "events";
    }

    val noEvents = StringBuilder().append("No hay eventos").toString()

    private fun getEvents(callback: (List<Event>?) -> Unit) {
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

    /*
        private fun getEvenByID(id :String, callback: (Event?) -> Unit) {

            var query = collection.document(id);

            query.get()
                .addOnSuccessListener { querySnapshot ->

                    val st = querySnapshot.toObject(Event::class.java)

                    callback(st)
                }
                .addOnFailureListener { exception ->
                    // Handle error
                    println("Error getting Pensum documents: $exception")
                }

        } */

    fun getEventDays(callback: (List<CalendarDay>?) -> Unit) {

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

    fun findEventsByDate(cal: String, callback: (List<Event>?) -> Unit) {
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

    fun getCalendarYear(): String {
        return EventUseCases().getCalendarYear()
    }

    fun descEvent(events: List<Event>): String {
        return EventUseCases().descEvent(events);
    }
}