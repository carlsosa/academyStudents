package com.student.unicdastudentsapp.ui.data.model

import kotlin.math.round

data class StudentCalification(
    val idSt: Long,
    val subjectId: Long,
    var totalGrade: Double,
    var firstPartial: Double,
    var secondPartial: Double,
    var projects: Double,
    var finalExam: Double,
) {
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