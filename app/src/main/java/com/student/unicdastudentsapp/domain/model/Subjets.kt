package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable
import kotlin.random.Random

@IgnoreExtraProperties
data class Subjets(@DocumentId var id: String = "",
              var name: String="",
              var quarter: Int=0) : Serializable {


    var code = ""
    var pensumID =""
    var credits = Random.nextInt(4, 5)

    var detail: String = StringBuilder().append("Creditos: ")
        .append(credits).toString()

   // exclude group
    @get:Exclude
    var classroom: String = "Hey Hey" + Random.nextInt(205, 405)
    @get:Exclude
    var profesor: String = ""
    @get:Exclude
    var dateHour: String = ""
    @get:Exclude
    var logoId = 0

    constructor() :this( name ="")
}