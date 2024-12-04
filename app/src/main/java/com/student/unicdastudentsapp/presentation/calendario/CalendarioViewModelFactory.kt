package com.student.unicdastudentsapp.presentation.calendario

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.domain.repository.EventsRepositoryImpl
import com.student.unicdastudentsapp.domain.use_case.EventUseCase

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class CalendarioViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(CalendarioViewModel::class.java)) {
            return CalendarioViewModel(
                eventUseCase = EventUseCase(EventsRepositoryImpl()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}