package com.student.unicdastudentsapp.presentation.logout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase
import kotlin.system.exitProcess

class LogOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserActiveUseCase.setUser(null)
        var viewModel = ViewModelProvider(this, LogOutViewModelFactory())
            .get(LogOutViewModel::class.java)
        viewModel.logOut()
        finish()
        exitProcess(0)
    }
}