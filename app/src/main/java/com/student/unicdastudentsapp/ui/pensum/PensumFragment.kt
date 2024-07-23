package com.student.unicdastudentsapp.ui.pensum

import android.R.attr.button
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
            }
        })
        var button_next = binding.btnAlante
        button_next.setOnClickListener(View.OnClickListener {
            if(index < 6 && index >= 1){
                index = index + 1 ;
                 setView(context,pensumViewModel,index)
            }
        })
        // access text views


            /*


            val textView_q4: TextView = binding.q4Label
            val textView_q5: TextView = binding.q5Label
            val textView_q6: TextView = binding.q6Label
            val textView_q7: TextView = binding.q7Label
            val textView_q8: TextView = binding.q8Label
            val textView_q9: TextView = binding.q9Label
            val textView_q10: TextView = binding.q10Label
            val textView_q11: TextView = binding.q11Label
            val textView_q12: TextView = binding.q12Label
    */



        // set text views

        /*


        textView_q4.text ="Cuarto Cuatrimestre"
        textView_q5.text ="Quinto Cuatrimestre"
        textView_q6.text ="Sexto Cuatrimestre"
        textView_q7.text ="Septimo Cuatrimestre"
        textView_q8.text ="Octavo Cuatrimestre"
        textView_q9.text ="Noveno Cuatrimestre"
        textView_q10.text ="Decimo Cuatrimestre"
        textView_q11.text ="Undecimo Cuatrimestre"
        textView_q11.text ="Duodecimo Cuatrimestre"

         */

       // access list views
       // val mListView1: ListView = binding.q1List;
        /*
        val mListView2: ListView = binding.q2List;
        val mListView3: ListView = binding.q3List;
        val mListView4: ListView = binding.q4List;
        val mListView5: ListView = binding.q5List;
        val mListView6: ListView = binding.q6List;
        val mListView7: ListView = binding.q7List;
        val mListView8: ListView = binding.q8List;
        val mListView9: ListView = binding.q9List;
        val mListView10: ListView = binding.q10List;
        val mListView11: ListView = binding.q11List;
        val mListView12: ListView = binding.q12List;

         */

        // set lists of quarters


        /*

        mListView4.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q4)

        mListView5.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q5)
        mListView6.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q6)
        mListView7.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q7)
        mListView8.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q8)

        mListView9.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q9)
        mListView10.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q10)
        mListView11.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q11)
        mListView12.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q12)

         */

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

            // val textView_q3: TextView = binding.q3Label
            // textView_q3.text ="Tercer Cuatrimestre"
            //val mListView3: ListView = binding.q3List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q2)
            // mListView3.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q3)

        }else if (index == 2){
            val textView_q1: TextView = binding.q1Label
            textView_q1.text ="4 Cuatrimestre"
            val mListView1: ListView = binding.q1List;
            mListView1.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q4)

            val textView_q2: TextView = binding.q2Label
            textView_q2.text ="5 Cuatrimestre"
            val mListView2: ListView = binding.q2List;

            // val textView_q3: TextView = binding.q3Label
            //textView_q3.text ="6ercer Cuatrimestre"
            //val mListView3: ListView = binding.q3List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q5)
            // mListView3.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q6)
        }else if(index == 3) {

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

            // val textView_q3: TextView = binding.q3Label
            // textView_q3.text ="Tercer Cuatrimestre"
            //val mListView3: ListView = binding.q3List;

            mListView2.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q2)
            // mListView3.adapter = ArrayAdapter(context,android.R.layout.simple_list_item_1,pensumViewModel.ing_soft_q3)


    }

}