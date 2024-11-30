package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.model.Student

object UserActiveUseCase {
    private var user: Student? = null

    fun getUser(): Student? {
        return user
    }

    fun setUser(student: Student?) {
        user = student
    }

    fun isUserActive(): Boolean {
        return user != null
    }
}