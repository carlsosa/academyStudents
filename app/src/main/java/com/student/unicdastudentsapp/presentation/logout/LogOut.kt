package com.student.unicdastudentsapp.presentation.logout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.unicdastudentsapp.domain.repository.AuthRepository
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase
import kotlin.system.exitProcess

class LogOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserActiveUseCase.setUser(null)
        AuthRepository().logOut()
        finish()
        exitProcess(0)
    }
}