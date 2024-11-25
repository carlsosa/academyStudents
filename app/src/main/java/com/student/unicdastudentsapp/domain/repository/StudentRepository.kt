package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.*;

import com.student.unicdastudentsapp.domain.model.Student

class StudentRepository {

  companion object {
   private const val COLNAME = "students";
  }

  private val db = FirebaseFirestore.getInstance()
  private val collection =  db.collection(COLNAME);

   fun getStudentByEmail(email: String) :Student {
    var student = Student("","",0);
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
          student.isActive = st.isActive

        }
    }
    return student;
  }

  private fun getStudentByEmail(email :String, callback: (Student?) -> Unit) {

     var query = collection.whereEqualTo("email",email);

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
       }

  }



}