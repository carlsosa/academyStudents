package com.student.unicdastudentsapp.ui.login

import com.student.unicdastudentsapp.ui.login.LoggedInUserView

/**
 * Authentication result : success (user details) or error message.
 */
data class LoginResult(
    val success: LoggedInUserView? = null,
    val error: Int? = null
)