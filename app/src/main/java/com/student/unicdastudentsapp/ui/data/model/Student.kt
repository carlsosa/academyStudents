package com.student.unicdastudentsapp.ui.data.model

data class Student(val name: String,val lastName: String, val id: Long){
    var age: Int = 0;
    var studyField: String ="";
    var date_init: String = "";
    var isActive: Boolean = false;
    var date_suspend: String ="";
    var profile_image: String="";
    var email: String ="";
    var password: String ="";
    var haveDebt: Boolean = false;
    var current_quarter: Int = 0;
    var SubjectsList = mutableListOf<Subjets>();
    var pensumID: Int = 0;
    var academicIndex: Int =0;
}
