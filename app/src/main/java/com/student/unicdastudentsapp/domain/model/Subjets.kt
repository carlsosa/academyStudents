package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable
import kotlin.random.Random

@IgnoreExtraProperties
class Subjets(@DocumentId var id: String = "", var name: String="", var quarter: Int=0) {


    var code = ""
    var dateHour: String = ""
    var classroom: String = "Hey Hey" + Random.nextInt(205, 405)
    var profesor: Professor? = null
    var currentQuarter: Int = 0
    var status: Boolean = true
    var credits = Random.nextInt(4, 5)
    var logoId = 0
    var detail: String = StringBuilder().append("Creditos: ")
        .append(credits).toString()


    constructor() :this( name ="")
}