package com.student.unicdastudentsapp.ui.pensum

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.student.unicdastudentsapp.databinding.FragmentPensumBinding


class PensumFragment : Fragment() {

    private var _binding: FragmentPensumBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    var index = 1;
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val pensumViewModel =
            ViewModelProvider(this).get(PensumViewModel::class.java)

        _binding = FragmentPensumBinding.inflate(inflater, container, false)
        val root: View = binding.root

         // set title
        val textView: TextView = binding.q1Txt
        pensumViewModel.text.observe(viewLifecycleOwner) {
            textView.text = it
        }
        val context = requireContext()
        setInitView(context, pensumViewModel)
        var button = binding.btnAtras
        button.setOnClickListener(View.OnClickListener {
            if(index > 1){
                index = index -1;
                setView(context,pensumViewModel,index)
            }
        })
        var button_next = binding.btnAlante
        button_next.setOnClickListener(View.OnClickListener {
            if(index < 6 && index >= 1){
                index = index + 1 ;
                 setView(context,pensumViewModel,index)
            }
        })

        return root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun setView(context: Context, pensumViewModel: PensumViewModel, index: Int){
        if(index == 1) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="Primer Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q1)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="Segundo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q2)

        }else if (index == 2){
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="Tercer Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q3)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="Cuarto Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q4)

        }else if(index == 3) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="Quinto Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q5)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="Sexto Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q6)
        }
        else if(index == 4) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="Septimo Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q7)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="Octavo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q8)
        }
        else if(index == 5) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="Noveno Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q9)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="Decimo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q10)
        }
        else if(index == 6) {
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="Undecimo Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q11)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="Duodecimo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q12)
        }
    }

    fun setInitView(context: Context, pensumViewModel: PensumViewModel){
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="Primer Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q1)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="Segundo Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q2)


    }

}