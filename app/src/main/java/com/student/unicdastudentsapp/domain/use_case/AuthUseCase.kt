package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.interfaces.AuthRepository

class AuthUseCase(private val auth: AuthRepository) {
    fun signIn(email: String, password: String, callback: (Boolean?) -> Unit){
      auth.signIn(email,password){
          callback(it)
      }
    }
    fun logOut(){
       auth.logOut()
    }

}