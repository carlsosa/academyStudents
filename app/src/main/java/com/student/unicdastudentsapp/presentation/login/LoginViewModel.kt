package com.student.unicdastudentsapp.presentation.login

import android.util.Patterns
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.domain.model.LoggedInUserView
import com.student.unicdastudentsapp.domain.model.LoginFormState
import com.student.unicdastudentsapp.domain.model.LoginResult
import com.student.unicdastudentsapp.domain.repository.AuthRepository
import com.student.unicdastudentsapp.domain.repository.LoginRepository
import com.student.unicdastudentsapp.domain.use_case.ResultLoginUseCase
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase


class LoginViewModel(private val loginRepository: LoginRepository) : ViewModel() {

    private val _loginForm = MutableLiveData<LoginFormState>()
    val loginFormState: LiveData<LoginFormState> = _loginForm

    private val _loginResult = MutableLiveData<LoginResult>()
    val loginResult: LiveData<LoginResult> = _loginResult
    var authRepo = AuthRepository()

     fun login(username: String, password: String) {
        // can be launched in a separate asynchronous job
         if (!UserActiveUseCase.isUserActive()) {
                 authRepo.signIn(username, password) { xp ->
                     if (xp != null && xp == true) {
                         println("Login 1")
                         loginBackground(username, password)
                     } else {
                         println("Usuario no existe 1")
                         _loginResult.value = LoginResult(error = R.string.userNotExists)
                     }
                 }

         }else if(UserActiveUseCase.getUser()!!.email != username){
             authRepo.logOut()
             authRepo.signIn(username,password) { xp ->
                 if (xp != null && xp == true) {
                     println("Login 2")
                      loginBackground(username,password)
                 } else {
                     println("Usuario no existe 2")
                     _loginResult.value = LoginResult(error = R.string.userNotExists)
                 }
             }
         } else{
             _loginResult.value =
                 LoginResult(success = LoggedInUserView(displayName = username))
         }

    }

    fun loginDataChanged(username: String, password: String) {
        if (!isUserNameValid(username)) {
            _loginForm.value = LoginFormState(usernameError = R.string.invalid_username)
        } else if (!isPasswordValid(password)) {
            _loginForm.value = LoginFormState(passwordError = R.string.invalid_password)
        } else {
            _loginForm.value = LoginFormState(isDataValid = true)
        }
    }

    // A placeholder username validation check
    private fun isUserNameValid(username: String): Boolean {
        return if (username.contains('@')) {
            Patterns.EMAIL_ADDRESS.matcher(username).matches()
        } else {
            username.isNotBlank()
        }
    }

    // A placeholder password validation check
    private fun isPasswordValid(password: String): Boolean {
        return password.length > 5
    }

    private fun loginBackground(username: String, password: String){
        loginRepository.login(username, password) { it ->
            if (it is ResultLoginUseCase.Success) {
                 _loginResult.value =
                 LoginResult(success = LoggedInUserView(displayName = it.data.displayName))
                println("Student fetched ${it.data.displayName}")
            } else if (it is ResultLoginUseCase.Error) {
                _loginResult.value = LoginResult(error = R.string.login_failed)
                println("Student not found ${username}")
            } else {
                 _loginResult.value = LoginResult(error = R.string.waiting)
                println("Waiting for student ${username}")
            }
        }
    }
}