package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.interfaces.SubjectsRepository
import com.student.unicdastudentsapp.domain.model.Subjets

class SubjectsUseCase(private val subjectsRepository: SubjectsRepository) {

    fun subjectsByPensumID(id: String, callback: (List<Subjets>?) -> Unit){
        subjectsRepository.subjectsByPensumID(id){
            callback(it)
        }
    }
    fun getSubjectsByQuarter(subjects: List<Subjets>?, quarter: Int = 0): List<Subjets>{
        return subjectsRepository.getSubjectsByQuarter(subjects)
    }
}