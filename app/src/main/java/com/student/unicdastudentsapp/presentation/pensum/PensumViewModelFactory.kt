package com.student.unicdastudentsapp.presentation.pensum

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.domain.repository.SubjectsRepositoryImpl
import com.student.unicdastudentsapp.domain.use_case.SubjectsUseCase

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class PensumViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PensumViewModel::class.java)) {
            return PensumViewModel(
                subjectsUseCase = SubjectsUseCase(SubjectsRepositoryImpl()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}