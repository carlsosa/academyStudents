package com.student.unicdastudentsapp.ui.materias

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.ui.data.model.Subjets

class MateriaAdapter(private val subjets: List<Subjets>) :

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
        var subject = subjets[idx]
        materiaViewHolder.name.text = subject.code +": "+subject.name
        materiaViewHolder.date.text = subject.date_hour
        materiaViewHolder.profesor.text = subject.profesor?.getCompleteName()
        materiaViewHolder.room.text = subject.classroom
        materiaViewHolder.logo.setImageResource(subject.logoId)
        materiaViewHolder.itemView.setOnClickListener {
            onClickListener?.onClick(idx,subject)
        }
    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }
    interface OnClickListener {
        fun onClick(position: Int, model: Subjets)

    }


}




