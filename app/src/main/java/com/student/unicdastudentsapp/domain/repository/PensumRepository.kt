package com.student.unicdastudentsapp.domain.repository;

import com.student.unicdastudentsapp.domain.model.Student
import com.student.unicdastudentsapp.domain.model.Subjets

class PensumRepository {


    fun getPensumQuarter(student: Student, qtNumber: Int, callback: (List<Subjets>?)-> Unit) {
         SubjectsRepository()
         .getSubjectsByPensumIDQuarter(student.pensumID,qtNumber){
             callback(it)
         }
    }

}
