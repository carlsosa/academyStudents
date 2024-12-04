package com.student.unicdastudentsapp.domain.interfaces

import com.google.firebase.firestore.CollectionReference
import com.google.firebase.firestore.FirebaseFirestore
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.model.Subjets

interface InscriptionsRepository {

    // Materias Activity
    fun getSubjectsByInscriptionUserID(
        userID: String,
        callback: (List<InscriptionSubjects>?) -> Unit
    )

    // pending activity
    fun pendingSubjectsByUserID(
        userID: String,
        pensumID: String,
        callback: (List<Subjets>?) -> Unit
    )

    fun getDetailsByIDInscription(
        id: String,
        callback: (List<InscriptionSubjects>?) -> Unit
    )
}