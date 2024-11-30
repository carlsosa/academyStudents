package com.student.unicdastudentsapp.presentation.grades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.unicdastudentsapp.databinding.ActivityGradeBinding
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.repository.InscriptionsRepository
import com.student.unicdastudentsapp.domain.use_case.InscriptionUseCases

class GradeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGradeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = InscriptionsRepository();
        binding = ActivityGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val subject = intent.extras?.get("EXTRA_GRADE") as InscriptionSubjects
        val title = binding.gradeTitle
        val desc = binding.gradeDesc
        title.text = subject.name
        desc.text = InscriptionUseCases().calification(subject)

    }
}