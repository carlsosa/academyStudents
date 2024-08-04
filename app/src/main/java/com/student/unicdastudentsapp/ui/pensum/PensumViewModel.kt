package com.student.unicdastudentsapp.ui.pensum

import android.R
import android.content.Context
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.student.unicdastudentsapp.databinding.FragmentPensumBinding
import com.student.unicdastudentsapp.ui.data.InitRepository
import com.student.unicdastudentsapp.ui.data.model.UserActive

class PensumViewModel : ViewModel() {

    private val _title = MutableLiveData<String>().apply {
        if (UserActive.isUserActive()) {
            value = UserActive.getUser()?.studyField
        } else {
            value = "N/A"
        }
    }
    val studyField: LiveData<String> = _title
    fun ing_soft_qt(qt: Int): List<String> {
        var user = UserActive.getUser()
        if (user != null) {
            return InitRepository().getPensumQuarter(user, qt)
        }
        return mutableListOf()
    }

    fun setInitView(
        context: Context,
        pensumViewModel: PensumViewModel,
        binding: FragmentPensumBinding
    ) {
        val textView_q1: TextView = binding.q1Label
        textView_q1.text = "Primer Cuatrimestre"
        val mListView1: ListView = binding.q1List;
        mListView1.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, ing_soft_qt(1))

        val textView_q2: TextView = binding.q2Label
        textView_q2.text = "Segundo Cuatrimestre"
        val mListView2: ListView = binding.q2List;

        mListView2.adapter =
            ArrayAdapter(context, android.R.layout.simple_list_item_1, ing_soft_qt(2))


    }

    fun setView(
        context: Context,
        pensumViewModel: PensumViewModel,
        index: Int,
        binding: FragmentPensumBinding
    ) {
        if (index == 1) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text = "Primer Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(1))

            val textView_q2: TextView = binding.q2Label
            textView_q2.text = "Segundo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(2))

        } else if (index == 2) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text = "Tercer Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(3))

            val textView_q2: TextView = binding.q2Label
            textView_q2.text = "Cuarto Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(4))

        } else if (index == 3) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text = "Quinto Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(5))

            val textView_q2: TextView = binding.q2Label
            textView_q2.text = "Sexto Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(6))
        } else if (index == 4) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text = "Septimo Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(7))

            val textView_q2: TextView = binding.q2Label
            textView_q2.text = "Octavo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(8))
        } else if (index == 5) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text = "Noveno Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(9))

            val textView_q2: TextView = binding.q2Label
            textView_q2.text = "Decimo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(10))
        } else if (index == 6) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text = "Undecimo Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(11))

            val textView_q2: TextView = binding.q2Label
            textView_q2.text = "Duodecimo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context, R.layout.simple_list_item_1, ing_soft_qt(12))
        }
    }

}