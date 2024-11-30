package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable


@IgnoreExtraProperties
data class News(@DocumentId val id: String="", val message: String="", val title: String="") : Serializable {
    var img: Int = 0
    var date: String = ""
    var link: String = ""
    var active = true

    constructor() :this( id = "" )
}

