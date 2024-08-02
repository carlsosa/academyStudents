package com.student.unicdastudentsapp.ui.data.model

import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.ui.data.model.Professor
import kotlin.random.Random

data class Subjets(val id: Long, val name: String, val quarter: Int){
    var code = "INGS-$id";
    var date_hour: String ="";
    var classroom: String = "E-"+Random.nextInt(205,405);
    var profesor : Professor? = null;
    var current_quarter: Int = 0;
    var status: Boolean = false;
    var credits = Random.nextInt(4,5);
    var logoId = 0

    fun getSubjects(): List<Subjets>{
        var sl = mutableListOf<Subjets>();
        var profes = getProfessors()
        // 1st year
        var x1 = Subjets(108,"Fundamentos de Programación",1)
        x1.profesor = profes[0]
        x1.date_hour="Lun-Mi 6:00-8:00 P.M"
        x1.logoId = R.drawable.purplebook

       var x2 =Subjets(109,"Álgebra",1)
        x2.profesor = profes[2]
        x2.date_hour="Mar-Ju 6:00-8:00 P.M"
        x2.logoId = R.drawable.redbook
        var x3= Subjets(110,"Algorítmica y Complejidad",1)
        x3.profesor= profes[1]
        x3.date_hour="Mar-Ju 8:00-10:00 P.M"
        x3.logoId = R.drawable.iconALG
        var x4= Subjets(111,"Análisis matemático",1)
        x4.profesor = profes[3]
        x4.date_hour="Lun-Mi 8:00-10:00 P.M"
        x4.logoId = R.drawable.math
        var x5=Subjets(112,"Arquitectura de computadores",1)
        x5.profesor = profes[4]
        x5.date_hour="Vie 6:00-10:00 P.M"
        x5.logoId = R.drawable.pc
        sl.add(x1)
        sl.add(x2)
        sl.add(x3)
        sl.add(x4)
        sl.add(x5)
        return sl;
    }
    fun getProfessors(): List<Professor>{
        var sl = mutableListOf<Professor>();
        sl.add(Professor(110,"Angelo","Roy"))
        sl.add(Professor(111,"Paola","Martinez"))
        sl.add(Professor(112,"Natanael","Ureña"))
        sl.add(Professor(113,"Regla","Portela"))
        sl.add(Professor(114,"Willy","Polanco"))
        return sl;
    }
}