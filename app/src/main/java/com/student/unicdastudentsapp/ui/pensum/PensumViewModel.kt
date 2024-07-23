package com.student.unicdastudentsapp.ui.pensum

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.ui.data.model.Pensum
import com.student.unicdastudentsapp.ui.data.model.Subjets

class PensumViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "INS:V1 Ingenieria de Software"
    }

    val text: LiveData<String> = _text
    val ing_soft_q0: List<String> = Pensum().getPensumSoftware().map { it.code +" " + it.name }
    val ing_soft_q1: List<String> = Pensum().getPensumSoftware().filter { it.quarter==1 }.map { it.code +" " + it.name }
    val ing_soft_q2: List<String> = Pensum().getPensumSoftware().filter { it.quarter==2 }.map { it.code +" " + it.name }
    val ing_soft_q3: List<String> = Pensum().getPensumSoftware().filter { it.quarter==3 }.map { it.code +" " + it.name }
    val ing_soft_q4: List<String> = Pensum().getPensumSoftware().filter { it.quarter==4 }.map { it.code +" " + it.name }

    val ing_soft_q5: List<String> = Pensum().getPensumSoftware().filter { it.quarter==5 }.map { it.code +" " + it.name }
    val ing_soft_q6: List<String> = Pensum().getPensumSoftware().filter { it.quarter==6 }.map { it.code +" " + it.name }
    val ing_soft_q7: List<String> = Pensum().getPensumSoftware().filter { it.quarter==7 }.map { it.code +" " + it.name }
    val ing_soft_q8: List<String> = Pensum().getPensumSoftware().filter { it.quarter==8 }.map { it.code +" " + it.name }

    val ing_soft_q9: List<String> = Pensum().getPensumSoftware().filter { it.quarter==9 }.map { it.code +" " + it.name }
    val ing_soft_q10: List<String> = Pensum().getPensumSoftware().filter { it.quarter==10 }.map { it.code +" " + it.name }
    val ing_soft_q11: List<String> = Pensum().getPensumSoftware().filter { it.quarter==11 }.map { it.code +" " + it.name }
    val ing_soft_q12: List<String> = Pensum().getPensumSoftware().filter { it.quarter==12 }.map { it.code +" " + it.name }

}