package com.student.unicdastudentsapp.presentation.pendientes

import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase
import com.student.unicdastudentsapp.domain.repository.InscriptionsRepository

class PendingSubjectsViewModel {


    fun pendingSubjects(callback: (List<Subjets>?) -> Unit) {
        var userID = UserActiveUseCase.getUser()?.id
        var pensumID = UserActiveUseCase.getUser()?.pensumID
        if(userID != null && pensumID != null) {
        InscriptionsRepository()
                .pendingSubjectsByUserID(userID, pensumID){
                    callback(it)
                }

        }
    }
}