package com.student.unicdastudentsapp.ui.perfil

import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentPerfilBinding
import com.student.unicdastudentsapp.ui.data.model.UserActive

class PerfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hello World!"
    }
    val text: LiveData<String> = _text

    fun init(_binding: FragmentPerfilBinding){
        var user = UserActive.getUser()
        if(user != null) {

            _binding.studentname.text = user.name
            _binding.studentID.text = user.matricula
            _binding.studentEmail.text = user.email
            _binding.studentField.text = user.studyField
            _binding.studentIndex.text = user.academicIndex.toString()
            _binding.studentGenre.text = user.genre
            _binding.perfilimg.setImageResource(user.profile_image)
            _binding.studentMobile.text = user.phoneNum

        }
    }

}