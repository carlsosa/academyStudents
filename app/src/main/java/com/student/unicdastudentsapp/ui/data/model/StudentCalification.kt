package com.student.unicdastudentsapp.ui.data.model

data class StudentCalification(
    val idSt: Long,
    val subjectId: Long,
    var totalGrade: Double,
    var firstPartial: Double,
    var secondPartial: Double,
    var projects: Double,
    var finalExam: Double,
) {
    var fulltext : String = StringBuilder().append("Primer Parcial: ").append(firstPartial)
        .append("\n")
        .append("Segundo Parcial: ").append(secondPartial)
        .append("\n")
        .append("Practicas: ").append(projects)
        .append("\n")
        .append("Examen Final: ").append(finalExam)
        .append("\n")
        .append("Total: ").append(totalGrade).toString()
}