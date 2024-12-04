package com.student.unicdastudentsapp.presentation.pendientes

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.use_case.InscriptionUseCases
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class PendingSubjectsViewModel(private val inscriptionUseCases: InscriptionUseCases)
    : ViewModel() {


    fun pendingSubjects(callback: (List<Subjets>?) -> Unit) {
        var userID = UserActiveUseCase.getUser()?.id
        var pensumID = UserActiveUseCase.getUser()?.pensumID
        if(userID != null && pensumID != null) {
        inscriptionUseCases
                .pendingSubjectsByUserID(userID, pensumID){
                    callback(it)
                }

        }
    }
}