package com.student.unicdastudentsapp.domain.repository

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import com.student.unicdastudentsapp.domain.interfaces.StudentRepository
import com.student.unicdastudentsapp.domain.model.Student

class StudentRepositoryImpl : StudentRepository {

    companion object {
        private const val COLNAME = "students";
    }


    override fun getStudentByLogin(email: String, pass: String, callback: (Student?) -> Unit) {

        Firebase.firestore.collection(COLNAME)
            .whereEqualTo("email", email)
            .whereEqualTo("password", pass)
            .whereEqualTo("isActive", true)
            .get()
            .addOnCompleteListener { snapshotTask ->
                if (snapshotTask.isSuccessful) {
                    // Get the first document that matches the query
                    val documentSnapshot = snapshotTask
                        .result
                        .documents
                        .mapNotNull { it.toObject(Student::class.java) }
                    Log.i("Working", documentSnapshot[0].email)
                    callback(documentSnapshot[0])

                } else {
                    println("User Not Found: $email")
                    Log.i("working but empty", "null user student")
                    callback(null)
                }
            }
            .addOnFailureListener { exception ->
                // Handle error
                Log.i("not working", "user student fail")
                println("Error getting Student documents: $exception")
                callback(null)
            }

    }


}