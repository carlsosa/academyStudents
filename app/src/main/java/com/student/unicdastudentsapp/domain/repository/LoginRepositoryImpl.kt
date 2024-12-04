package com.student.unicdastudentsapp.domain.repository

import com.student.unicdastudentsapp.data.local.LoginDataSource
import com.student.unicdastudentsapp.domain.interfaces.LoginRepository
import com.student.unicdastudentsapp.domain.model.LoggedInUser
import com.student.unicdastudentsapp.domain.use_case.ResultLoginUseCase

/**
 * Class that requests authentication and user information from the remote data source and
 * maintains an in-memory cache of login status and user credentials information.
 */

class LoginRepositoryImpl(override val dataSource: LoginDataSource) : LoginRepository {

    // in-memory cache of the loggedInUser object
    override var user: LoggedInUser? = null
        set

    override val isLoggedIn: Boolean
        get() = user != null

    init {
        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
        user = null
    }

    override fun logout() {
        user = null
        dataSource.logout()
    }

    override fun login(
        username: String,
        password: String,
        callback: (ResultLoginUseCase<LoggedInUser>) -> Unit
    ) {
        // handle login
        dataSource.login(username, password) {

            if (it is ResultLoginUseCase.Success) {
                setLoggedInUser(it.data)
                callback(it)
            } else {
                callback(it)
            }

        }

    }

    override fun setLoggedInUser(loggedInUser: LoggedInUser) {
        this.user = loggedInUser

        // If user credentials will be cached in local storage, it is recommended it be encrypted
        // @see https://developer.android.com/training/articles/keystore
    }
}