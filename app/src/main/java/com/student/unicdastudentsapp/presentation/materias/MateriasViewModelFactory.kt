package com.student.unicdastudentsapp.presentation.materias

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.domain.repository.InscriptionsRepositoryImpl
import com.student.unicdastudentsapp.domain.use_case.InscriptionUseCases

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class MateriasViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MateriasViewModel::class.java)) {
            return MateriasViewModel(
                inscriptionUseCases = InscriptionUseCases(InscriptionsRepositoryImpl()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}