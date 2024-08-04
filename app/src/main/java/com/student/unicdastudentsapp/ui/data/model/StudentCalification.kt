package com.student.unicdastudentsapp.ui.data.model

data class StudentCalification(
    val idSt: Long,
    val subjectId: Long,
    var total_grade: Double,
    var first_partial: Double,
    var second_partial: Double,
    var projects: Double,
    var finalExam: Double,
    var fulltext : String = StringBuilder().append("Primer Parcial: ").append(first_partial)
        .append("\n")
        .append("Segundo Parcial: ").append(second_partial)
        .append("\n")
        .append("Practicas: ").append(projects)
        .append("\n")
        .append("Examen Final: ").append(finalExam)
        .append("\n")
        .append("Total: ").append(total_grade).toString()
) {
}