package com.student.unicdastudentsapp.presentation.pensum

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.Subjets
import com.student.unicdastudentsapp.domain.use_case.SubjectsUseCase
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class PensumViewModel(private val subjectsUseCase: SubjectsUseCase) : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = if (UserActiveUseCase.isUserActive()) {
            UserActiveUseCase.getUser()?.field
        } else {
            "N/A"
        }
    }
    val studyField: LiveData<String> = _title

    fun subjects(callback: (List<Subjets>?) -> Unit) {
        var userID = UserActiveUseCase.getUser()?.id
        var pensumID = UserActiveUseCase.getUser()?.pensumID
        if(userID != null && pensumID != null) {
               subjectsUseCase.subjectsByPensumID(pensumID)
                {
                    callback(it)
                }

        }
    }

}