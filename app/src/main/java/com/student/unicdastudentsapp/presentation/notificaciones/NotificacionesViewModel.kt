package com.student.unicdastudentsapp.presentation.notificaciones

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.model.News
import com.student.unicdastudentsapp.domain.repository.NewsRepository

class NotificacionesViewModel : ViewModel() {
    fun getnews(callback: (List<News>?)-> Unit){
        NewsRepository().getNews {
            callback(it)
        }
    }
}