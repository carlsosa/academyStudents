package com.student.unicdastudentsapp.domain.repository

import com.student.unicdastudentsapp.data.remote.api.FirebaseAuth.firebaseAuth

class AuthRepository {


    fun signIn(email: String, password: String, callback: (Boolean?)-> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                println("Firebase Auth: Succesfully logged in")
                callback(true)

            } else
                println("Firebase Auth: could not logged in")
                callback(false)
        }
    }

    fun logOut(){
        println("Logged out")
        firebaseAuth.signOut();
    }
}