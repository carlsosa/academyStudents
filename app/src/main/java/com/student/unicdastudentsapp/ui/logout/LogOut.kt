package com.student.unicdastudentsapp.ui.logout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.unicdastudentsapp.ui.data.model.UserActive
import kotlin.system.exitProcess

class LogOut : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        UserActive.setUser(null)
        finish()
        exitProcess(0)
    }
}