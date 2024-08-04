package com.student.unicdastudentsapp.ui.pensum

import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.databinding.FragmentPensumBinding
import com.student.unicdastudentsapp.ui.data.InitRepository
import com.student.unicdastudentsapp.ui.data.model.UserActive

class PensumViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        value = if (UserActive.isUserActive()) {
            UserActive.getUser()?.studyField
        } else {
            "N/A"
        }
    }
    val studyField: LiveData<String> = _title
    private fun ingSoftQt(qt: Int): List<String> {
        val user = UserActive.getUser()
        if (user != null) {
            return InitRepository().getPensumQuarter(user, qt)
        }
        return mutableListOf()
    }

    fun setInitView(
        context: Context,
        binding: FragmentPensumBinding
    ) {
        val textviewQ1: TextView = binding.q1Label
        textviewQ1.text = context.getString(R.string.primer_cuatrimestre)
        val mListView1: ListView = binding.q1List
        mListView1.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, ingSoftQt(1))

        val textviewQ2: TextView = binding.q2Label
        textviewQ2.text = context.getString(R.string.segundo_cuatrimestre)
        val mListView2: ListView = binding.q2List

        mListView2.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, ingSoftQt(2))


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
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(1))

                textviewQ2.text = context.getString(R.string.segundo_cuatrimestre)
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(2))

            }
            2 -> {
                textviewQ1.text = context.getString(R.string.tercer_cuatrimestre)
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(3))

                textviewQ2.text = context.getString(R.string.cuarto_cuatrimestre)
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(4))

            }
            3 -> {
                textviewQ1.text = context.getString(R.string.quinto_cuatrimestre)
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(5))

                textviewQ2.text = context.getString(R.string.sexto_cuatrimestre)
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(6))
            }
            4 -> {
                textviewQ1.text = context.getString(R.string.septimo_cuatrimestre)
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(7))

                textviewQ2.text = context.getString(R.string.octavo_cuatrimestre)
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(8))
            }
            5 -> {
                textviewQ1.text = context.getString(R.string.noveno_cuatrimestre)
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(9))

                textviewQ2.text = context.getString(R.string.decimo_cuatrimestre)
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(10))
            }
            6 -> {
                textviewQ1.text = context.getString(R.string.undecimo_cuatrimestre)
                mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(11))

                textviewQ2.text = context.getString(R.string.duodecimo_cuatrimestre)
                mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ingSoftQt(12))
            }
        }
    }

}