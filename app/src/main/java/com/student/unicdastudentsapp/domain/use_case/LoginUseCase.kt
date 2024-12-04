package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.interfaces.LoginRepository
import com.student.unicdastudentsapp.domain.model.LoggedInUser

class LoginUseCase(private val loginRepository: LoginRepository) {
    fun logout(){
        loginRepository.logout()
    }
    fun login(
        username: String,
        password: String,
        callback: (ResultLoginUseCase<LoggedInUser>) -> Unit
    ){
        loginRepository.login(username,password){
            callback(it);
        }
    }

    fun setLoggedInUser(loggedInUser: LoggedInUser){
        loginRepository.setLoggedInUser(loggedInUser);
    }
}