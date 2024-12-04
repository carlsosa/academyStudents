package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.model.Event
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.model.Student

object UserActiveUseCase {
    private var user: Student? = null

    fun getUser(): Student? {
        return user
    }

    fun setUser(student: Student?) {
        user = student
    }

    fun isUserActive(): Boolean {
        return user != null
    }

    private var user_ins: InscriptionSubjects? = null
    fun getIns(): InscriptionSubjects? {
        return user_ins
    }

    fun setIns(it: InscriptionSubjects?) {
        user_ins = it
    }
    private var user_events: List<Event>? = null
    fun getUserEvents() :List<Event> ? {
        return user_events
    }
    fun setUserEvents(it: List<Event>){
        user_events = it
    }

}