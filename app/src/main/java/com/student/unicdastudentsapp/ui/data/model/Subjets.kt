package com.student.unicdastudentsapp.ui.data.model

import com.student.unicdastudentsapp.ui.data.model.Professor

data class Subjets(val id: Long, val name: String, val PensumID: Int){
    var code = "INGS-$id";
    var date_hour: String ="";
    var classroom: String = "";
    var profesor : Professor? = null;
    var current_quarter: Int = 0;
    var status: Boolean = false;
}