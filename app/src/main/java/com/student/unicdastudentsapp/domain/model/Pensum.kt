package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.IgnoreExtraProperties

@IgnoreExtraProperties
class Pensum(var pensumID: Int=0, var numberOfQuarter: Int=0, var subjets: List<Subjets>?){

    constructor() :this( pensumID = 0)
}
