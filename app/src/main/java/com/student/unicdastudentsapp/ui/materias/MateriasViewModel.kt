package com.student.unicdastudentsapp.ui.materias

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.ui.data.model.Pensum
import com.student.unicdastudentsapp.ui.data.model.Subjets

class MateriasViewModel : ViewModel() {

    val qt1: List<Subjets> = Subjets(0,"",0).getSubjects()
}