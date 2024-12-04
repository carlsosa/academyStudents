package com.student.unicdastudentsapp.domain.interfaces

import com.student.unicdastudentsapp.domain.model.Subjets

interface SubjectsRepository {
    fun subjectsByPensumID(id: String, callback: (List<Subjets>?) -> Unit)
    fun getSubjectsByQuarter(subjects: List<Subjets>?, quarter: Int = 0): List<Subjets>
}