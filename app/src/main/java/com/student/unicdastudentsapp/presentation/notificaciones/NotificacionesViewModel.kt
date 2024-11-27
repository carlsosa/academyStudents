package com.student.unicdastudentsapp.presentation.notificaciones

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.domain.repository.NewsRepository

class NotificacionesViewModel : ViewModel() {
    var n1=  NewsRepository().getNews();
}