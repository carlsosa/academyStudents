package com.student.unicdastudentsapp.presentation.materias

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.presentation.data.InitRepository
import com.student.unicdastudentsapp.presentation.data.model.Subjets
import com.student.unicdastudentsapp.presentation.data.model.UserActive

class MateriasViewModel : ViewModel() {

    val qt1: List<Subjets> = InitRepository()
        .getUsers()
        .filter { it.email == (UserActive.getUser()?.email ?: "") }[0].subjetsList
}