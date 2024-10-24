package com.student.unicdastudentsapp.presentation.notificaciones

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.presentation.data.InitRepository

class NotificacionesViewModel : ViewModel() {
    var n1= InitRepository().getNews()
}