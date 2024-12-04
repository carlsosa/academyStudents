package com.student.unicdastudentsapp.domain.repository

import com.student.unicdastudentsapp.data.remote.api.FirebaseAuth.firebaseAuth
import com.student.unicdastudentsapp.domain.interfaces.AuthRepository

class AuthRepositoryImpl : AuthRepository {


    override fun signIn(email: String, password: String, callback: (Boolean?) -> Unit) {
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                println("Firebase Auth: Succesfully logged in")
                callback(true)

            } else
                println("Firebase Auth: could not logged in")
            callback(false)
        }
    }

    override fun logOut() {
        println("Logged out")
        firebaseAuth.signOut();
    }
}