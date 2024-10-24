package com.student.unicdastudentsapp.presentation.data


import com.student.unicdastudentsapp.presentation.data.model.LoggedInUser
import com.student.unicdastudentsapp.presentation.data.model.UserActive
import java.io.IOException

/**
 * Class that handles authentication w/ login credentials and retrieves user information.
 */
class LoginDataSource {

    fun login(username: String, password: String): Result<LoggedInUser> {
        try {
            val user = InitRepository().getUsers().filter { it.email==username }.filter { it.password==password }.get(0)
            val userDisplat = LoggedInUser(user.id.toString(),user.name)
            if(user != null){ UserActive.setUser(user)}
            return Result.Success(userDisplat)
        } catch (e: Throwable) {
            return Result.Error(IOException("Error logging in", e))
        }
    }

    fun logout() {
        // TODO: revoke authentication
    }
}