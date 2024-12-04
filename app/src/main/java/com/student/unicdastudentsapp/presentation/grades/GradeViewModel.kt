package com.student.unicdastudentsapp.presentation.grades

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.use_case.InscriptionUseCases

class GradeViewModel(private val inscriptionUseCases: InscriptionUseCases) : ViewModel() {


    fun  calification (i: InscriptionSubjects, callback: (String?)->Unit)  {
       inscriptionUseCases.calification(i){
           callback(it)
       }
    }


}