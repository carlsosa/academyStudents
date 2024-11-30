package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.model.Student
import com.student.unicdastudentsapp.domain.repository.SubjectsRepository

object UserActiveUseCase {
    private var user: Student? = null

    fun getUser(): Student? {
        return user
    }

    fun setUser(student: Student?) {
        user = student
        try{
            if(user != null) {
                SubjectsRepository().subjectsByPensumID(user!!.pensumID) {
                    println("pensum en el login: ejecutado")
                }
            }
        }catch(e: Exception){
            println("exception pensum login")
        }

    }

    fun isUserActive(): Boolean {
        return user != null
    }
}