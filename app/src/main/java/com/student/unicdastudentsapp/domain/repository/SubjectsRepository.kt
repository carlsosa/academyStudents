package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.student.unicdastudentsapp.domain.model.PensumSubject
import com.student.unicdastudentsapp.domain.model.Subjets

class SubjectsRepository {

    companion object {
       private const val COLNAME = "subjects";
        private const val COLNAMEPS ="PensumSubjects";
    }

    private val db = FirebaseFirestore.getInstance()
    private val collection =  db.collection(COLNAME);
    private val collectionPS =  db.collection(COLNAMEPS);



    fun getSubjectsByPensumID(id: String) : List<Subjets>{
        val subjets = mutableListOf<Subjets>();
        getSubjectsByPensumID(id){ s ->
            if (s != null) {
                for (i in s){
                    subjets.add(i);
                }
            }
        }
        return subjets;
    }

    private fun getSubjectsByPensumID(id: String,callback: (List<Subjets>?) -> Unit ){
        collectionPS.whereEqualTo("pensumID",id)
            .whereEqualTo("active",true)
            .get()
            .addOnSuccessListener { documents ->
                val subjets = mutableListOf<Subjets>()
                if(!documents.isEmpty) {
                    for (document in documents) {
                        val  ps = document.toObject(PensumSubject::class.java)
                        val s = getSubjectByID(ps.subjectID);
                        subjets.add(s);
                    }
                    println("Se encontro materias ")
                    callback(subjets);
                }else{
                    println("No se encontro materias ")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }

    private fun getSubjectByID(id :String, callback: (Subjets?) -> Unit) {

        var query = collection.document(id);

        query.get()
            .addOnSuccessListener { querySnapshot ->

                val st = querySnapshot.toObject(Subjets::class.java)

                callback(st)
            }
            .addOnFailureListener { exception ->
                // Handle error
                println("Error getting Pensum documents: $exception")
            }

    }

    fun getSubjectByID(id: String) :Subjets {
        var p = Subjets(0,"",0)
        getSubjectByID(id){ st->
            if(st != null){
              p.id = st.id
                p.name = st.name
                p.detail = st.detail
                p.code = st.code
                p.quarter = st.quarter
                p.credits = st.credits

            }
        }
        return p;
    }


}