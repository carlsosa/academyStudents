package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Pensum(@DocumentId var pensumID: String="", var numberOfQuarter: Int=0, var subjets: List<Subjets>?= emptyList()) :
    Serializable {

    constructor() :this( pensumID = "")
}
