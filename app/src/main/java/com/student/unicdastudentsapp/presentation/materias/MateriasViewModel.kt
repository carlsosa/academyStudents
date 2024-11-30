package com.student.unicdastudentsapp.presentation.materias

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase
import com.student.unicdastudentsapp.domain.repository.InscriptionsRepository

class MateriasViewModel : ViewModel() {

    fun selection(callback: ( List<InscriptionSubjects>?)-> Unit) =  InscriptionsRepository()
        .getSubjectsByInscriptionUserID(UserActiveUseCase.getUser()?.id ?: ""){
            callback(it)
        }


}