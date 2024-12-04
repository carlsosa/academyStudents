package com.student.unicdastudentsapp.domain.interfaces

interface FirebaseMessagingRepository {
    fun saveToken(values: HashMap<String, String>)
}