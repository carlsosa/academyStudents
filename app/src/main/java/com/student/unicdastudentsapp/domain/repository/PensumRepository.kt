package com.student.unicdastudentsapp.domain.repository;

import com.student.unicdastudentsapp.domain.model.Student
import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class PensumRepository {

    var subsList = mutableListOf<Subjets>();

    fun Init(student: Student, callback: (List<Subjets>?)-> Unit){
        SubjectsRepository().subjectsByPensumID(student.pensumID){
            if(subsList.isEmpty()) {
                if (it != null) {
                    println("se encontraron materias del pensum....")
                    subsList.addAll(it)
                }
            }
        }
        callback(subsList)
    }
    fun getPensumQuarter(qtNumber: Int, callback: (List<Subjets>?)-> Unit) {
        if(subsList.isNotEmpty()) {
            var list = SubjectsRepository().getSubjectsByQuarter(subsList, qtNumber);
            println("pensum filtrado por cuatrimestres...")
            callback(list)
        }else {
            UserActiveUseCase.getUser()?.let {
                Init(it){
                    println("List was no ready")
                }
            }
        }
    }


}
