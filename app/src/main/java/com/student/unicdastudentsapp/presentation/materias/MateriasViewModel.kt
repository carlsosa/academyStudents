package com.student.unicdastudentsapp.presentation.materias

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.model.UserActive
import com.student.unicdastudentsapp.domain.repository.InscriptionsRepository

class MateriasViewModel : ViewModel() {

    val qt1: List<Subjets> = InscriptionsRepository()
        .getSubjectsByInscriptionUserID(UserActive.getUser()?.id ?: "");
}