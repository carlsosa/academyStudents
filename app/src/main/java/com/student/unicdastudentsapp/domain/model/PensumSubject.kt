package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class PensumSubject( var pensumID :String ="",
var subjectID :String = "", var active: Boolean = true) {


    constructor() :this( active = true )
}