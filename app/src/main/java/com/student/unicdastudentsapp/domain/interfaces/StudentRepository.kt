package com.student.unicdastudentsapp.domain.interfaces

import com.student.unicdastudentsapp.domain.model.Student

interface StudentRepository {
    fun getStudentByLogin(email: String, pass: String, callback: (Student?) -> Unit)

}