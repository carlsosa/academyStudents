package com.student.unicdastudentsapp.domain.interfaces

interface AuthRepository {
    fun signIn(email: String, password: String, callback: (Boolean?) -> Unit)
    fun logOut()
}