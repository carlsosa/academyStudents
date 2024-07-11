package com.student.unicdastudentsapp.ui.data.model

data class Pensum(val id: Long){
    var numberOfQuarter = 12;
    var numberOfSubjects = 4*12;
     var SubjectsList = mutableListOf<Subjets>();
}
