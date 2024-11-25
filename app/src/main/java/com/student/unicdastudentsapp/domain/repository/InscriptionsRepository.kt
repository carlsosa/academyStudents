package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.student.unicdastudentsapp.domain.model.Inscription
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.model.Subjets

class InscriptionsRepository {


    companion object {
        private const val COLNAME = "Inscriptions";
        private const val COLNAMEIS ="InscriptionSubjects";
    }

    private val db = FirebaseFirestore.getInstance()
    private val collection =  db.collection(COLNAME);
    private val collectionIS =  db.collection(COLNAMEIS);



    fun getDetailsByInscID(id: String) : List<InscriptionSubjects>{
        val subjets = mutableListOf<InscriptionSubjects>();
        getDetailsByIDInscription(id){ s ->
                for (i in s){
                    if (i != null) {
                        subjets.add(i)
                    };
                }
        }
        return subjets;
    }

    private fun getDetailsByIDInscription(id: String,callback: (List<InscriptionSubjects?>) -> Unit ){
        collectionIS.whereEqualTo("inscriptionID",id)
            .whereEqualTo("isCompleted",false)
            .whereEqualTo("isRetired", false)
            .get()
            .addOnSuccessListener { documents ->
                val subjets = mutableListOf<InscriptionSubjects>()
                if(!documents.isEmpty) {
                    for (document in documents) {
                        val  ps = document.toObject(InscriptionSubjects::class.java)
                        subjets.add(ps);
                    }
                    println("Se encontro inscripciones ")
                    callback(subjets);
                }else{
                    println("No se encontro inscripciones ")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }

    private fun getInscriptionByUserID(id :String, callback: (Inscription?) -> Unit) {

        var query = collection.whereEqualTo("StudentID",id)
            .whereEqualTo("active",true);

        query.get()
            .addOnSuccessListener { querySnapshot ->
                if (!querySnapshot.isEmpty) {
                    var st = querySnapshot.documents.first()
                    var iS = st.toObject(Inscription::class.java)


                    callback(iS)
                }
            }
            .addOnFailureListener { exception ->
                // Handle error
                println("Error getting Pensum documents: $exception")
            }

    }

    fun getInscriptionByUserID(id: String) : Inscription {
        var p = Inscription()
        getInscriptionByUserID(id){ st->
            if(st != null){
               p.id = st.id
                p.StudentID = st.StudentID

            }
        }
        return p;
    }

}