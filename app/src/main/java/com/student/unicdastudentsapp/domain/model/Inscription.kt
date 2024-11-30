package com.student.unicdastudentsapp.domain.model

import com.google.firebase.firestore.DocumentId
import com.google.firebase.firestore.IgnoreExtraProperties
import java.io.Serializable

@IgnoreExtraProperties
data class Inscription (var StudentID :String ="",
                        @DocumentId var id :String ="") : Serializable {

                               constructor(): this(id="")
}