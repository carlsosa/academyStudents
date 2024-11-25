package com.student.unicdastudentsapp.domain.model

import java.io.Serializable
import kotlin.random.Random

data class Subjets(var id: Long, var name: String, var quarter: Int) : Serializable {
    var code = "INGS-$id"
    var dateHour: String = ""
    var classroom: String = "E-" + Random.nextInt(205, 405)
    var profesor: Professor? = null
    var currentQuarter: Int = 0
    var status: Boolean = true
    var credits = Random.nextInt(4, 5)
    var logoId = 0
    var detail: String = StringBuilder().append("Creditos: ")
        .append(credits).toString()


}