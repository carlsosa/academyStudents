package com.student.unicdastudentsapp.presentation.materias

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.use_case.InscriptionUseCases


class MateriaAdapter(private val subjets: List<InscriptionSubjects>) :

    RecyclerView.Adapter<MateriaAdapter.MateriaViewHolder>() {
    private var onClickListener: OnClickListener? = null

    class MateriaViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.subject_name)
        var date: TextView = itemView.findViewById(R.id.subject_date)
        var profesor: TextView = itemView.findViewById(R.id.subject_profesor)
        var room: TextView = itemView.findViewById(R.id.subject_room)
        var logo: ImageView = itemView.findViewById(R.id.avatar)

    }

    override fun getItemCount(): Int {
        return subjets.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): MateriaViewHolder {
        val v: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item, viewGroup, false)
        return MateriaViewHolder(v)
    }

    override fun onBindViewHolder(materiaViewHolder: MateriaViewHolder, idx: Int) {
        val subject = subjets[idx]
        materiaViewHolder.name.text = StringBuilder().append(subject.code)
            .append(": " ).append(subject.name).toString()
        materiaViewHolder.date.text = InscriptionUseCases().getHour(subject)
        materiaViewHolder.profesor.text = subject.teacherID
        materiaViewHolder.room.text = subject.classroom
        if(subject.code.contains("MA")) {
            materiaViewHolder.logo.setImageResource(R.drawable.math)
        }else if(subject.code.contains("AL")){
            materiaViewHolder.logo.setImageResource(R.drawable.pc)
        }else{
            materiaViewHolder.logo.setImageResource(R.drawable)
        }
        materiaViewHolder.itemView.setOnClickListener {
            onClickListener?.onClick(idx, subject)
        }
    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: InscriptionSubjects)

    }


}




