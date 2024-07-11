package com.student.unicdastudentsapp.ui.data.model

data class StudentCalification (val idStudent: Long, val subjectId: Long){
    var total_grade = 100.0;
    var student_current_grade : Double = 0.0 / total_grade;

    fun printDetails(): String {
        if(student_current_grade >= 70.0){
            return "Aprobado";
        }else{
            return "Reprobado";
        }
    }


}