package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class PensumSubject(@DocumentId var pensumID :String ="",
                         @DocumentId var subjectID :String = "", var active: Boolean = true): Serializable {


    constructor() :this( active = true )
}