package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.IgnoreExtraProperties


@IgnoreExtraProperties
class Event(var date: String?, var event: String?, var selfCalendar: String){
   var month = 5;
    var day =3;
    var year = 2024;

    constructor() :this( day  =  5)
}