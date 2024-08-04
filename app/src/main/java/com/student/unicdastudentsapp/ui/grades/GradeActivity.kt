package com.student.unicdastudentsapp.ui.grades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.unicdastudentsapp.databinding.ActivityGradeBinding
import com.student.unicdastudentsapp.ui.data.InitRepository
import com.student.unicdastudentsapp.ui.data.model.Subjets
import com.student.unicdastudentsapp.ui.data.model.UserActive

class GradeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGradeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val subject = intent.extras?.get("EXTRA_GRADE") as Subjets
        var grade =
            UserActive.getUser()?.id?.let { InitRepository().getSubjectGrade(it, subject.id) }
        val title = binding.gradeTitle
        val desc = binding.gradeDesc
        if (subject != null && grade != null) {
            title.text = subject.name
            desc.text = grade.fulltext
        }

    }
}