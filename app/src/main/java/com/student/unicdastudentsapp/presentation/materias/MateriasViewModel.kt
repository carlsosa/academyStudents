package com.student.unicdastudentsapp.presentation.materias

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.use_case.InscriptionUseCases
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class MateriasViewModel( private val inscriptionUseCases: InscriptionUseCases) : ViewModel() {


    fun selection(callback: ( List<InscriptionSubjects>?)-> Unit) {
        inscriptionUseCases
            .getSubjectsByInscriptionUserID(UserActiveUseCase.getUser()?.id ?: "") {
                callback(it)
            }
    }


}