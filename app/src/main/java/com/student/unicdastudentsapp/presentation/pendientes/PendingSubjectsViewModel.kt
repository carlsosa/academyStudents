package com.student.unicdastudentsapp.presentation.pendientes

import com.student.unicdastudentsapp.domain.repository.InitRepository
import com.student.unicdastudentsapp.domain.model.Subjets

class PendingSubjectsViewModel {

    val qt1: List<Subjets> = InitRepository()
        .getSubjectsPendingByUser()
}