package com.student.unicdastudentsapp.ui.data.model

import com.student.unicdastudentsapp.R
import java.io.Serializable

data class News(val id: Long, val message: String, val title: String) : Serializable{
    var img: Int = 0
    var date :String =""
    var link :String =""
}

