package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class InscriptionSubjects {
    var id =""
    var Subject =""
   var  inscriptionID =""
    var teacherID =""
    var Day1 =""
    var Day2=""
    var Exam1= 0.0
    var Exam2 =0.0
    var FinalExam =0.0
    var HomeWorks = 0.0
    var Hora1 =""
    var Hora2 =""
    var isCompleted =false
    var isRetired= false


}