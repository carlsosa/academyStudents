package com.student.unicdastudentsapp.ui.notificaciones

import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.ui.data.InitRepository
import com.student.unicdastudentsapp.ui.data.model.News

class NotificacionesViewModel : ViewModel() {
    var n1= InitRepository().getNews()
}