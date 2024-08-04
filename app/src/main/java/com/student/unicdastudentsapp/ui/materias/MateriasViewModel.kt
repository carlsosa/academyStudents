package com.student.unicdastudentsapp.ui.materias

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.ui.data.InitRepository
import com.student.unicdastudentsapp.ui.data.model.Subjets
import com.student.unicdastudentsapp.ui.data.model.UserActive

class MateriasViewModel : ViewModel() {

    val qt1: List<Subjets> = InitRepository()
        .getUsers()
        .filter { it.email == (UserActive.getUser()?.email ?: "") }[0].subjetsList
}