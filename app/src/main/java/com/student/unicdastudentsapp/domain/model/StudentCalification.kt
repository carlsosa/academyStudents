package com.student.unicdastudentsapp.domain.model

import kotlin.math.round

 class StudentCalification(){
    val idSt: String =""
    val subjectId: String =""
    var totalGrade: Double = 0.0
    var firstPartial: Double =0.0
    var secondPartial: Double = 0.0
    var projects: Double = 0.0
    var finalExam: Double =0.0
    var fulltext : String = StringBuilder().append("Primer Parcial: ").append(round(firstPartial*100)/100)
        .append("\n")
        .append("Segundo Parcial: ").append(round(secondPartial*100)/100)
        .append("\n")
        .append("Practicas: ").append(round(projects*100)/100)
        .append("\n")
        .append("Examen Final: ").append(round(finalExam*100)/100)
        .append("\n")
        .append("Total: ").append(round(totalGrade*100)/100).toString()
}