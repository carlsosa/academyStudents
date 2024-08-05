package com.student.unicdastudentsapp.ui.pendientes

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.student.unicdastudentsapp.databinding.ActivityPendingSubjectsBinding
import com.student.unicdastudentsapp.ui.data.model.UserActive

class PendingSubjectsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityPendingSubjectsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPendingSubjectsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (UserActive.isUserActive()) {
            var sub = PendingSubjectsViewModel().qt1
            val recyclerView = binding.recyclerViewPendings
            recyclerView.setHasFixedSize(true)
            val linearLayoutManager = LinearLayoutManager(this)
            recyclerView.layoutManager = linearLayoutManager
            val adapter = PendingSubjectsAdapter(sub)
            recyclerView.adapter = adapter
        }
    }



}