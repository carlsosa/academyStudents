package com.student.unicdastudentsapp.domain.repository

import com.applandeo.materialcalendarview.CalendarDay
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.domain.model.Event
import java.util.Calendar

class EventsRepository {

    companion object {
        private const val COLNAME = "events";
    }

    private val db = FirebaseFirestore.getInstance()
    private val collection =  db.collection(COLNAME);

    val noEvents = StringBuilder().append("No hay eventos").toString()



    fun getEvents() : List<Event>{
        val events = mutableListOf<Event>();
        getEvents(){ s ->
            if (s != null) {
                for (i in s){
                    events.add(i);
                }
            }
        }
        return events;
    }
    fun getEventByID(id: String) : Event {
        var event = Event("","","");
        getEvenByID(id){ e ->
            if(e != null){
                event.event = e.event;
                event.date =  e.date;
                event.selfCalendar = e.date.toString()
                event.day = e.day
                event.year = e.year
                event.month = e.month
            }
        }
        return  event;
    }


    private fun getEvents(callback: (List<Event>?) -> Unit ){
        collection.whereEqualTo("active",true)
            .orderBy("date", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                val events = mutableListOf<Event>()
                if(!documents.isEmpty) {
                    for (document in documents) {
                        val  ps = document.toObject(Event::class.java)
                        events.add(ps);
                    }
                    println("Se encontro eventos ")
                    callback(events);
                }else{
                    println("No se encontro eventos ")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }


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

    }

    fun getEventDays(): List<CalendarDay> {

        // set calendar
        val calendarDays = mutableListOf<CalendarDay>()
      getEvents() { docs ->

          if (docs != null) {
              for (c in docs) {
                  val calendar = Calendar.getInstance()
                  calendar.set(c.year,c.month-1, c.day);
                  val calendarDay = CalendarDay(calendar)
                  calendarDays.add(calendarDay)
                  /*
                  events.add(
                      Event(
                          calendarDay.calendar.time.date.toString(),
                          c.event,
                          calendarDay.calendar.time.toString()
                      )
                  )
                   */
                  calendarDays.forEach {
                      it.imageResource = R.drawable.calendar
                      it.labelColor = R.color.teal_700
                  }
              }
          }
      }
        return calendarDays
    }

    fun findEventsByDate(cal: String): List<Event> {
         var events = mutableListOf<Event>()
        getEvents() { docs ->

            if (docs != null) {
                for (c in docs) {
                    val calendar = Calendar.getInstance()
                    calendar.set(c.year,c.month-1, c.day);
                    val calendarDay = CalendarDay(calendar)
                    if(calendarDay.calendar.time.date.toString()==cal){
                    events.add(
                        Event(
                            calendarDay.calendar.time.date.toString(),
                            c.event,
                            calendarDay.calendar.time.toString()
                        )
                    )
                    }

                }
            }
        }
        return events;
    }

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