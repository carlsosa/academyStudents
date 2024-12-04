package com.student.unicdastudentsapp.domain.interfaces

import com.student.unicdastudentsapp.data.local.LoginDataSource
import com.student.unicdastudentsapp.domain.model.LoggedInUser
import com.student.unicdastudentsapp.domain.use_case.ResultLoginUseCase

interface LoginRepository {
    val dataSource: LoginDataSource

    // in-memory cache of the loggedInUser object
    var user: LoggedInUser?
    val isLoggedIn: Boolean

    fun logout()
    fun login(
        username: String,
        password: String,
        callback: (ResultLoginUseCase<LoggedInUser>) -> Unit
    )

    fun setLoggedInUser(loggedInUser: LoggedInUser)
}