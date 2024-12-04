package com.student.unicdastudentsapp.presentation.notificaciones

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.News
import com.student.unicdastudentsapp.domain.use_case.NewsUseCase

class NotificacionesViewModel(private val newsUseCase: NewsUseCase) : ViewModel() {
    fun getnews(callback: (List<News>?)-> Unit){
        newsUseCase.getNews {
            callback(it)
        }
    }
}