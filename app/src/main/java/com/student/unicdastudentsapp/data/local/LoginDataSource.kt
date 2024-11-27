package com.student.unicdastudentsapp.data.local


import com.student.unicdastudentsapp.domain.model.LoggedInUser
import com.student.unicdastudentsapp.domain.model.UserActive
import com.student.unicdastudentsapp.domain.model.Result
import com.student.unicdastudentsapp.domain.repository.StudentRepository
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String, callback: (Result<LoggedInUser>)-> Unit){

        try {
         StudentRepository().getStudentByLogin(username,password) { user ->
             if(user != null ) {
                 if (user.email != "") {
                     val userDisplat = LoggedInUser(user.id, user.name)
                     UserActive.setUser(user)
                     callback(Result.Success(userDisplat))
                 }
             }
         }
           throw Exception();
        } catch (e: Throwable) {
            callback(Result.Error(IOException("Error logging in", e)))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}