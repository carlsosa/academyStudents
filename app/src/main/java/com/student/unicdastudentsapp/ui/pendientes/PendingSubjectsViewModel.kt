package com.student.unicdastudentsapp.ui.pendientes

import com.student.unicdastudentsapp.ui.data.InitRepository
import com.student.unicdastudentsapp.ui.data.model.Subjets
import com.student.unicdastudentsapp.ui.data.model.UserActive

class PendingSubjectsViewModel {

    val qt1: List<Subjets> = InitRepository()
        .getSubjectsPendingByUser()
}