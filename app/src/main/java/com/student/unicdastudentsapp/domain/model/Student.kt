package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.Exclude
import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
 class Student(
    @DocumentId var id: String = "",
    var name: String = "",
    var lastName: String = "",
    var phoneNum: String = "",
    var matricula: String = "",
    var age: Int = 0,
    var studyField: String = "",
   // var dateInit: String = "",
    var isActive: Boolean = false,
   // var dateSuspend: String? = null,
    var profileImage: String? = null,
    var email: String = "",
    var password: String = "",
    var pensumID: String = "",
    var academicIndex: Double = 0.0,
    var genre: String = ""
) {
     constructor() :this( isActive=true)
    // excluir de BD
    @get:Exclude
    var fullName: String = ""
        get() = "$name $lastName"
}

