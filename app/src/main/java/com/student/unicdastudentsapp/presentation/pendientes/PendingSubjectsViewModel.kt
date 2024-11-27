package com.student.unicdastudentsapp.presentation.pendientes

import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.model.UserActive
import com.student.unicdastudentsapp.domain.repository.InscriptionsRepository

class PendingSubjectsViewModel {


    fun pendingSubjects() :List<Subjets>{
        var userID = UserActive.getUser()?.id
        var pensumID = UserActive.getUser()?.pensumID
        if(userID != null && pensumID != null) {
            val qt1: List<Subjets> = InscriptionsRepository()
                .pendingSubjectsByUserID(userID, pensumID)
            return qt1;
        }
        return emptyList()
    }
}