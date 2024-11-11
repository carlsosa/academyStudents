package com.student.unicdastudentsapp.presentation.materias

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.repository.InitRepository
import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.model.UserActive

class MateriasViewModel : ViewModel() {

    val qt1: List<Subjets> = InitRepository()
        .getUsers()
        .filter { it.email == (UserActive.getUser()?.email ?: "") }[0].subjetsList
}