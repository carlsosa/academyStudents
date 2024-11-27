package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.IgnoreExtraProperties


@IgnoreExtraProperties
 class News(val id: Long, val message: String, val title: String) {
    var img: Int = 0
    var date: String = ""
    var link: String = ""

    constructor() :this( message ="")
}

