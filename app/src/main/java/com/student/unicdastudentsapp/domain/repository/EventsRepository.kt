package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.model.News
import com.student.unicdastudentsapp.domain.model.Subjets

class EventsRepository {

    companion object {
        private const val COLNAME = "events";
    }

    private val db = FirebaseFirestore.getInstance()
    private val collection =  db.collection(COLNAME);



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

}