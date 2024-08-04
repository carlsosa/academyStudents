package com.student.unicdastudentsapp.ui.notificaciones

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.ui.data.InitRepository

class NotificacionesViewModel : ViewModel() {
    var n1= InitRepository().getNews()
}