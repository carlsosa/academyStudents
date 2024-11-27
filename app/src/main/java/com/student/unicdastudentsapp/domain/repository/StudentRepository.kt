package com.student.unicdastudentsapp.domain.repository

import android.util.Log
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

import com.student.unicdastudentsapp.domain.model.Student
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.util.concurrent.Executors

class StudentRepository {

  companion object {
   private const val COLNAME = "students";
  }

  private val db = Firebase.firestore;


   fun getStudentByEmail(email: String) :Student {
    var student = Student("","","");
    getStudentByEmail(email){st->
        if(st != null){
          student.id = st.id
          student.email = st.email
          student.name = st.name
          student.lastName = st.lastName
          student.age = st.age
          student.pensumID = st.pensumID
          student.genre = st.genre
          student.password = st.password
          student.phoneNum = st.phoneNum
          student.isActive = st.isActive;
            student.matricula = st.matricula

        }
    }
    return student;
  }
    var studentList = mutableListOf<Student>();
    fun getStudentByLogin(email: String, pass: String, callback: (Student?)-> Unit) {
        getStudentByLoginV1(email, pass){
            t-> callback(t)
        }
    }

  private fun getStudentByEmail(email :String, callback: (Student?) -> Unit) {
      val collection =  db.collection(COLNAME);
     var query = collection
         .whereEqualTo("email",email)
         .whereEqualTo("isActive", true);

     query.get()
       .addOnSuccessListener { querySnapshot ->
         if (!querySnapshot.isEmpty) {
           // Get the first document that matches the query
           val documentSnapshot = querySnapshot.documents.first()

           // Map the document snapshot to a Student object
          val st = documentSnapshot.toObject(Student::class.java)

           callback(st)
         } else {

           println("User Not Found: $email")
           callback(null)
         }
       }
       .addOnFailureListener { exception ->
         // Handle error

         println("Error getting Student documents: $exception")
           callback(null)
       }

  }

  private  fun getStudentByLoginV1(email :String, pass: String, callback: (Student?) -> Unit) {
        studentList = mutableListOf<Student>()
         db.collection(COLNAME)
          .whereEqualTo("email",email)
           .whereEqualTo("password",pass)
           .whereEqualTo("isActive", true)
           .get()
            .addOnCompleteListener { snapshotTask ->
                if (snapshotTask.isSuccessful) {
                    // Get the first document that matches the query
                    val documentSnapshot = snapshotTask
                        .result
                        .documents
                        .mapNotNull { it.toObject(Student::class.java) }
                    Log.i("Working",documentSnapshot[0].email)
                    studentList.add(documentSnapshot[0])
                    callback(documentSnapshot[0])

                } else {
                    println("User Not Found: $email")
                    Log.i("working but empty","null user student")
                  callback(null)
                }
            }
            .addOnFailureListener { exception ->
                // Handle error
                Log.i("not working","user student fail")
                println("Error getting Student documents: $exception")
               callback(null)
            }

    }



}