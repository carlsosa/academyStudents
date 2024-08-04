package com.student.unicdastudentsapp.ui.perfil

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.databinding.FragmentPerfilBinding
import com.student.unicdastudentsapp.ui.data.model.UserActive

class PerfilViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "Hello World!"
    }
    val text: LiveData<String> = _text

    fun init(binding: FragmentPerfilBinding){
        val user = UserActive.getUser()
        if(user != null) {

            binding.studentname.text = user.name
            binding.studentID.text = user.matricula
            binding.studentEmail.text = user.email
            binding.studentField.text = user.studyField
            binding.studentIndex.text = user.academicIndex.toString()
            binding.studentGenre.text = user.genre
            binding.perfilimg.setImageResource(user.profileImage)
            binding.studentMobile.text = user.phoneNum

        }
    }

}