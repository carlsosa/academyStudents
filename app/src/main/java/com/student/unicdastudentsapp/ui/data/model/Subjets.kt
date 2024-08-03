package com.student.unicdastudentsapp.ui.data.model

import com.student.unicdastudentsapp.R
import java.io.Serializable
import kotlin.random.Random

data class Subjets(val id: Long, val name: String, val quarter: Int) : Serializable {
    var code = "INGS-$id";
    var date_hour: String ="";
    var classroom: String = "E-"+Random.nextInt(205,405);
    var profesor : Professor? = null;
    var current_quarter: Int = 0;
    var status: Boolean = true;
    var credits = Random.nextInt(4,5);
    var logoId = 0


}