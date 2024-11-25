package com.student.unicdastudentsapp.domain.repository;

import com.google.firebase.firestore.FirebaseFirestore
import com.student.unicdastudentsapp.domain.model.Pensum

public class PensumRepository {


    companion object {
        private const val COLNAME = "pensums";
    }
    private val db = FirebaseFirestore.getInstance()
    private val collection =  db.collection(COLNAME);


    fun getPensumByID(id: String) :Pensum {
        var p = Pensum(0,1,null);
        getPensum(id){ st->
            if(st != null){
               p.pensumID = st.pensumID
                p.numberOfQuarter = st.numberOfQuarter
            }
        }
        return p;
    }

    private fun getPensum(id :String, callback: (Pensum?) -> Unit) {

        var query = collection.document(id);

        query.get()
            .addOnSuccessListener { querySnapshot ->

                    val st = querySnapshot.toObject(Pensum::class.java)

                    callback(st)
            }
            .addOnFailureListener { exception ->
                // Handle error
                println("Error getting Pensum documents: $exception")
            }

    }

}
