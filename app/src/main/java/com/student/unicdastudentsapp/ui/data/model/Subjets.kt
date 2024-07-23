package com.student.unicdastudentsapp.ui.data.model

import com.student.unicdastudentsapp.ui.data.model.Professor
import kotlin.random.Random

data class Subjets(val id: Long, val name: String, val quarter: Int){
    var code = "INGS-$id";
    var date_hour: String ="";
    var classroom: String = "E-"+Random.nextInt(205,405);
    var profesor : Professor? = null;
    var current_quarter: Int = 0;
    var status: Boolean = false;
    var credits = Random.nextInt(4,5);
}