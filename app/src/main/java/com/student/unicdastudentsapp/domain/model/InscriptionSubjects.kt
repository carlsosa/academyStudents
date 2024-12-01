package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class InscriptionSubjects(@DocumentId var id: String ="", var Subject :String ="",
                               var  inscriptionID: String ="",
                               var isCompleted: Boolean =false) : Serializable {

    var teacherID =""
    var teacherEmail =""
    var Day1 =""
    var Day2=""
    var Exam1= 0.0
    var Exam2 =0.0
    var FinalExam =0.0
    var Homeworks = 0.0
    var Hora1 =""
    var Hora2 =""
    var classroom =""
    var code =""
    var name =""

    var isRetired= false

    constructor() :this( isCompleted = false)

}