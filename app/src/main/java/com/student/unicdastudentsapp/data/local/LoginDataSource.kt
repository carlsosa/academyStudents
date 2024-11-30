package com.student.unicdastudentsapp.data.local


import com.student.unicdastudentsapp.domain.model.LoggedInUser
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase
import com.student.unicdastudentsapp.domain.use_case.ResultLoginUseCase
import com.student.unicdastudentsapp.domain.repository.StudentRepository
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String, callback: (ResultLoginUseCase<LoggedInUser>)-> Unit){

        try {
         StudentRepository().getStudentByLogin(username,password) { user ->
             if(user != null ) {
                 if (user.email != "") {
                     val userDisplat = LoggedInUser(user.id, user.name)
                     UserActiveUseCase.setUser(user)
                     callback(ResultLoginUseCase.Success(userDisplat))
                 }
             }
         }
           throw Exception();
        } catch (e: Throwable) {
            callback(ResultLoginUseCase.Error(IOException("Error logging in", e)))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}