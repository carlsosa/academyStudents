package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.student.unicdastudentsapp.domain.model.Subjets

class SubjectsRepository {

    companion object {
       private const val COLNAME = "subjects";
    }

    fun getSubjectsByPensumIDQuarter(id: String, quarter: Int, callback: (List<Subjets>?)-> Unit) {
        getAllSubjectsByPensumIDQuarter(id, quarter){ s ->
            callback(s)
        }
    }

    private fun getAllSubjectsByPensumIDQuarter(id: String,quarter: Int, callback: (List<Subjets>?) -> Unit ){
       val db = FirebaseFirestore.getInstance()
         val collection =  db.collection(COLNAME);
        collection.whereEqualTo("pensumID",id)
            .whereEqualTo("quarter",quarter)
            .get()
            .addOnCompleteListener { documents ->
                val subjets = mutableListOf<Subjets>()
                if(documents.isSuccessful) {
                    for (document in documents.result) {
                        val  ps = document.toObject(Subjets::class.java)
                        subjets.add(ps);
                    }
                    println("Se encontro materias para pensumID $id ")
                    callback(subjets);
                }else{
                    println("No se encontro materias para PensumID $id")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }


}