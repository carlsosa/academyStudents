package com.student.unicdastudentsapp.presentation.logout

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.data.local.LoginDataSource
import com.student.unicdastudentsapp.domain.repository.AuthRepositoryImpl
import com.student.unicdastudentsapp.domain.repository.EventsRepositoryImpl
import com.student.unicdastudentsapp.domain.repository.InscriptionsRepositoryImpl
import com.student.unicdastudentsapp.domain.repository.LoginRepositoryImpl
import com.student.unicdastudentsapp.domain.use_case.AuthUseCase
import com.student.unicdastudentsapp.domain.use_case.EventUseCase
import com.student.unicdastudentsapp.domain.use_case.InscriptionUseCases

/**
 * ViewModel provider factory to instantiate LoginViewModel.
 * Required given LoginViewModel has a non-empty constructor
 */
class LogOutViewModelFactory : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LogOutViewModel::class.java)) {
            return LogOutViewModel(
                logAuth = AuthUseCase(AuthRepositoryImpl()
                )
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}