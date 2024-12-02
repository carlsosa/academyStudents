package com.student.unicdastudentsapp.presentation.pensum

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.domain.model.Subjets

class PensumSubjectsAdapter(private val subjets: List<Subjets>) :

    RecyclerView.Adapter<PensumSubjectsAdapter.PendingSubjectsViewHolder>() {

    class PendingSubjectsViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var name: TextView = itemView.findViewById(R.id.subjectPensumNam)
    }

    override fun getItemCount(): Int {
        return subjets.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): PendingSubjectsViewHolder {
        val v: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_pensum, viewGroup, false)
        return PendingSubjectsViewHolder(v)
    }

    override fun onBindViewHolder(pendingSubjectsViewHolder: PendingSubjectsViewHolder, idx: Int) {
        val subject = subjets[idx]
        pendingSubjectsViewHolder.name.text = StringBuilder().append(subject.quarter).append(" | ").append(subject.code)
            .append(": " ).append(subject.name).append(" | ").append(subject.credits).toString()
    }




}




