package com.student.unicdastudentsapp.presentation.pensum

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentPensumBinding
import com.student.unicdastudentsapp.domain.repository.PensumRepository
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class PensumViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = if (UserActiveUseCase.isUserActive()) {
            UserActiveUseCase.getUser()?.field
        } else {
            "N/A"
        }
    }
    val studyField: LiveData<String> = _title
    private val _pensumRepo =  PensumRepository();

    private fun ingSoftQt(qt: Int, callbacks:  (List<String>)-> Unit) {
        var list = mutableListOf<String>();
        _pensumRepo.getPensumQuarter(qt){ it->
                if (it != null) {
                    for(i in it){
                        list.add("${i.code} - ${i.name}")
                    }
                }
            }
        callbacks(list)
    }

    fun setInitView(
        context: Context,
        binding: FragmentPensumBinding
    ) {
        val textviewQ1: TextView = binding.q1Label
        textviewQ1.text = context.getString(R.string.primer_cuatrimestre)
        val mListView1: ListView = binding.q1List
        ingSoftQt(1) {
            mListView1.adapter =
                ArrayAdapter(context, android.R.layout.simple_list_item_1,it)
        }

        val textviewQ2: TextView = binding.q2Label
        textviewQ2.text = context.getString(R.string.segundo_cuatrimestre)
        val mListView2: ListView = binding.q2List

        ingSoftQt(2){
        mListView2.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, it)}


    }

    fun setView(
        context: Context,
        index: Int,
        binding: FragmentPensumBinding
    ) {
        val textviewQ1: TextView = binding.q1Label
        val textviewQ2: TextView = binding.q2Label

        val mListView1: ListView = binding.q1List
        val mListView2: ListView = binding.q2List
        when (index) {
            1 -> {
                textviewQ1.text = context.getString(R.string.primer_cuatrimestre)
                ingSoftQt(1) {
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}

                textviewQ2.text = context.getString(R.string.segundo_cuatrimestre)
                ingSoftQt(2) {
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}

            }
            2 -> {
                textviewQ1.text = context.getString(R.string.tercer_cuatrimestre)
                ingSoftQt(3) {
                    mListView1.adapter =
                        ArrayAdapter(context, R.layout.simple_list_item_1, it)
                }

                textviewQ2.text = context.getString(R.string.cuarto_cuatrimestre)
                ingSoftQt(4){
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}

            }
            3 -> {
                textviewQ1.text = context.getString(R.string.quinto_cuatrimestre)
                ingSoftQt(5){
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1,it )}

                textviewQ2.text = context.getString(R.string.sexto_cuatrimestre)
                ingSoftQt(6){
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}
            }
            4 -> {
                textviewQ1.text = context.getString(R.string.septimo_cuatrimestre)
                ingSoftQt(7){
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}

                textviewQ2.text = context.getString(R.string.octavo_cuatrimestre)
                ingSoftQt(8){
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}
            }
            5 -> {
                textviewQ1.text = context.getString(R.string.noveno_cuatrimestre)
                ingSoftQt(9){
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1,it )}

                textviewQ2.text = context.getString(R.string.decimo_cuatrimestre)
                ingSoftQt(10){
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}
            }
            6 -> {
                textviewQ1.text = context.getString(R.string.undecimo_cuatrimestre)
                ingSoftQt(11){
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}

                textviewQ2.text = context.getString(R.string.duodecimo_cuatrimestre)
                ingSoftQt(12){
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, it)}
            }
        }
    }

    fun initPensum(){
        val user = UserActiveUseCase.getUser()
        if (user != null && user.subjets.isNullOrEmpty() ) {
            _pensumRepo.Init(user){
              if(!it.isNullOrEmpty()){
                  println("Encontro pensum...${user.pensumID}")
              }else{
                  println("no encontro el pensum ${user.pensumID}")
              }
            }
        }

    }
    fun pensumIsReady() :Boolean {
        return  _pensumRepo.subsList.isNotEmpty() || UserActiveUseCase.getUser()!!.subjets!!.isNotEmpty()
    }
}