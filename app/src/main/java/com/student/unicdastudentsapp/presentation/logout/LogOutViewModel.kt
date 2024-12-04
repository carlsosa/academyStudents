package com.student.unicdastudentsapp.presentation.logout

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.use_case.AuthUseCase


class LogOutViewModel(private val logAuth: AuthUseCase) : ViewModel() {

    fun logOut(){
        logAuth.logOut()
    }
}