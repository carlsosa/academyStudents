package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.student.unicdastudentsapp.domain.interfaces.InscriptionsRepository
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.model.Subjets

class InscriptionsRepositoryImpl : InscriptionsRepository {


    companion object {
        private const val COLNAMEIS = "InscriptionSubjects";
    }

     val db = FirebaseFirestore.getInstance()
     val collectionIS = db.collection(COLNAMEIS);


    // Materias Activity
    override fun getSubjectsByInscriptionUserID(
        userID: String,
        callback: (List<InscriptionSubjects>?) -> Unit
    ) {
        getDetailsByIDInscription(userID) { t ->
            callback(t)
        }

    }

    // pending activity
    override fun pendingSubjectsByUserID(
        userID: String,
        pensumID: String,
        callback: (List<Subjets>?) -> Unit
    ) {

        db.collection("pendings").whereEqualTo("studentID", userID)
            .whereEqualTo("pensumID", pensumID)
            .whereEqualTo("pending", true)
            .get()
            .addOnCompleteListener() { documents ->
                val subjets = mutableListOf<Subjets>()
                if (documents.isSuccessful) {
                    for (document in documents.result.documents) {
                        val ps = document.toObject(Subjets::class.java)
                        if (ps != null) {
                            subjets.add(ps);
                        }
                    }
                    println("Se encontro inscripciones ")
                    callback(subjets);
                } else {
                    println("No se encontro inscripciones ")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }

    override fun getDetailsByIDInscription(
        id: String,
        callback: (List<InscriptionSubjects>?) -> Unit
    ) {
        collectionIS.whereEqualTo("studentID", id)
            .whereEqualTo("active", true)
            .whereEqualTo("isRetired", false)
            .get()
            .addOnCompleteListener() { documents ->
                if (documents.isSuccessful) {
                    var s =
                        documents.result.documents.mapNotNull { it.toObject(InscriptionSubjects::class.java) }
                    println("Se encontro inscripciones ")
                    callback(s);
                } else {
                    println("No se encontro inscripciones ")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }


}