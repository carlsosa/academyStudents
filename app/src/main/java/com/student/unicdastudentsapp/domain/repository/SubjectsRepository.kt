package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class SubjectsRepository {

    companion object {
       private const val COLNAME = "subjects";
    }



  fun subjectsByPensumID(id: String, callback: (List<Subjets>?) -> Unit ){
       val db = FirebaseFirestore.getInstance()
         val collection =  db.collection(COLNAME);
        collection.whereEqualTo("pensumID",id)
            .orderBy("quarter", Query.Direction.ASCENDING)
            .get()
            .addOnCompleteListener { documents ->
                if(documents.isSuccessful) {
                    println("Se encontro materias para pensumID $id ")
                     val sub = documents.result.documents.mapNotNull { it.toObject(Subjets::class.java) }
                    val user = UserActiveUseCase.getUser()
                    if(user != null){
                        user.subjets = sub;
                    }
                    callback(sub);
                }else{
                    println("No se encontro materias para PensumID $id")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }

  fun getSubjectsByQuarter(subjects: List<Subjets>?,quarter: Int =0): List<Subjets> {
            if(subjects != null && quarter > 0){
              val qt = subjects.filter { it.quarter == quarter }
                  //  .map { it.code + " " + it.name }
                return  qt;
            }else{
                val user = UserActiveUseCase.getUser()
                if(user?.subjets != null){
                    val qt = user.subjets!!.filter { it.quarter == quarter }
                    //  .map { it.code + " " + it.name }
                    return  qt;
                }
            }
       return emptyList()
    }


}