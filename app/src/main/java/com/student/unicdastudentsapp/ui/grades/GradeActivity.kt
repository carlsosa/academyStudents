package com.student.unicdastudentsapp.ui.grades

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.student.unicdastudentsapp.databinding.ActivityGradeBinding
import com.student.unicdastudentsapp.ui.data.model.Subjets

class GradeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityGradeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // enableEdgeToEdge()
        binding = ActivityGradeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        /*
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
         */
        val subject = intent.extras?.get("EXTRA_GRADE") as Subjets
        val title = binding.gradeTitle
        val desc = binding.gradeDesc
        if(subject != null) {
            title.text = subject.name
            desc.text =
                "Primer Parcial: " + "20/20" + "\n" + "Segundo Parcial: " + 15 / 20 + "\n" + "Practicas: " + "30/30" + "\n" + "Examen Final: " + "28/30" + "."
        }

    }
}