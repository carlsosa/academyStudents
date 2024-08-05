package com.student.unicdastudentsapp.ui.pendientes

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.ui.data.model.Subjets

class PendingSubjectsAdapter(private val subjets: List<Subjets>) :

    RecyclerView.Adapter<PendingSubjectsAdapter.PendingSubjectsViewHolder>() {

    class PendingSubjectsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.subjectPendNam)
        var img: ImageView = itemView.findViewById(R.id.avatar2)
        var details : TextView = itemView.findViewById(R.id.subjectPendDet)
    }

    override fun getItemCount(): Int {
        return subjets.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PendingSubjectsViewHolder {
        val v: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_pending, viewGroup, false)
        return PendingSubjectsViewHolder(v)
    }

    override fun onBindViewHolder(pendingSubjectsViewHolder: PendingSubjectsViewHolder, idx: Int) {
        val subject = subjets[idx]
        pendingSubjectsViewHolder.name.text = StringBuilder().append(subject.code)
            .append(": " ).append(subject.name).toString()
        pendingSubjectsViewHolder.img.setImageResource(R.drawable.subjects)
        pendingSubjectsViewHolder.details.text = subject.detail
    }




}




