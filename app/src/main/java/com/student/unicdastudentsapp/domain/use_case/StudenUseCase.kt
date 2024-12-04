package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.interfaces.StudentRepository
import com.student.unicdastudentsapp.domain.model.Student

class StudenUseCase(private val studentRepository: StudentRepository) {
    fun getStudentByLogin(email: String, pass: String, callback: (Student?) -> Unit){
        studentRepository.getStudentByLogin(email,pass){
            callback(it)
        }
    }

}