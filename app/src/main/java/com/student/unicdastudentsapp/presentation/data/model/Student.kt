package com.student.unicdastudentsapp.presentation.data.model

import java.io.Serializable

data class Student(val name: String,val lastName: String, val id: Long) : Serializable{
    var phoneNum: String =""
    var matricula: String =""
    var age: Int = 0
    var studyField: String =""
    var dateInit: String = ""
    var isActive: Boolean = false
    var dateSuspend: String =""
    var profileImage: Int = 0
    var email: String =""
    var password: String =""
    var haveDebt: Boolean = false
    var currentQuarter: Int = 0
    // user relationshio with dummy subjects
    var subjetsList : List<Subjets> = mutableListOf()
    var pensumID: Int = 0
    var academicIndex: Double =0.0
    var genre : String =""


}
