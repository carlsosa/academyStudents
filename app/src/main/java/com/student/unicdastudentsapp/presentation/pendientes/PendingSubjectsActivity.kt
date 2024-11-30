package com.student.unicdastudentsapp.presentation.pendientes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.databinding.ActivityPendingSubjectsBinding
import com.student.unicdastudentsapp.domain.use_case.UserActiveUseCase

class PendingSubjectsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPendingSubjectsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingSubjectsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (UserActiveUseCase.isUserActive()) {

            val recyclerView = binding.recyclerViewPendings
            recyclerView.setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = linearLayoutManager
            PendingSubjectsViewModel().pendingSubjects(){
                if(it != null) {
                    val adapter = PendingSubjectsAdapter(it)
                    recyclerView.adapter = adapter
                }
            }

        }
    }

}