package com.student.unicdastudentsapp.presentation.evento

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.domain.repository.EventsRepositoryImpl
import com.student.unicdastudentsapp.domain.use_case.EventUseCase

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class EventsViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EventViewModel::class.java)) {
            return EventViewModel(
                  event = EventUseCase(EventsRepositoryImpl()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}