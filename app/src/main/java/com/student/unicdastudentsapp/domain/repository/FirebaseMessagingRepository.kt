package com.student.unicdastudentsapp.domain.repository

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseMessagingRepository {

    fun saveToken( values: HashMap<String, String>){
         FirebaseFirestore
             .getInstance()
             .collection("tokens")
            .add(values)
            .addOnSuccessListener { documentReference ->
                Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
            }
            .addOnFailureListener { e ->
                Log.w(TAG, "Error adding document", e)
            }
    }
}