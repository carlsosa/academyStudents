package com.student.unicdastudentsapp.presentation.pendientes

import com.student.unicdastudentsapp.presentation.data.InitRepository
import com.student.unicdastudentsapp.presentation.data.model.Subjets

class PendingSubjectsViewModel {

    val qt1: List<Subjets> = InitRepository()
        .getSubjectsPendingByUser()
}