package com.student.unicdastudentsapp.presentation.data.model

import java.io.Serializable

data class Professor(val id: Long, val name: String, val lastName: String) : Serializable {

    fun getCompleteName(): String {
        return "$name $lastName"
    }


}
