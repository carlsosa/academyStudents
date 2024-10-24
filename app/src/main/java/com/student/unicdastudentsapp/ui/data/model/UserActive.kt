package com.student.unicdastudentsapp.ui.data.model

object UserActive {
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