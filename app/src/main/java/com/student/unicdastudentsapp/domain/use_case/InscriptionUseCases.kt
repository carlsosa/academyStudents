package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.interfaces.InscriptionsRepository
import com.student.unicdastudentsapp.domain.model.InscriptionSubjects
import com.student.unicdastudentsapp.domain.model.Subjets
import kotlin.math.round

class InscriptionUseCases(private val insRepo: InscriptionsRepository) {

    fun getHour(ins: InscriptionSubjects): String {
        var text  = StringBuilder();
        if (ins.Day1.isNotBlank() && ins.Hora1.isNotBlank()){
            text.append("${ins.Day1} : ${ins.Hora1}")
        }
        if (ins.Day2.isNotBlank() && ins.Hora2.isNotBlank()){
            text.append("\n")
            text.append("${ins.Day2} : ${ins.Hora2}")
        }
        return text.toString()
    }

 fun  calification (i: InscriptionSubjects, callback: (String?)-> Unit) {
     val total= round((
             i.Exam1.plus(i.Exam2).plus(i.Homeworks).plus(i.FinalExam)
             ));
    var formatedText= StringBuilder().append("Primer Parcial: ").append(round(i.Exam1*100) /100)
         .append("\n")
         .append("Segundo Parcial: ").append(round(i.Exam2))
         .append("\n")
         .append("Practicas: ").append(round(i.Homeworks))
         .append("\n")
         .append("Examen Final: ").append(round(i.FinalExam))
         .append("\n")
         .append("Total: ").append(total.toInt())
         .append("\n")
         .append("Literal: ")
         .append(getGradeLiteral(total.toInt())).toString();
     callback(formatedText)

 }

    private fun getGradeLiteral(i: Int): String {
        if(i in 70..79){
            return "C"
        }
        if(i in 80..89){
            return "B"
        }
        if(i in 90..100){
            return "A"
        }
        return "F"
    }

    fun getSubjectsByInscriptionUserID(
        userID: String,
        callback: (List<InscriptionSubjects>?) -> Unit
    ){
        insRepo.getSubjectsByInscriptionUserID(userID) { it->
            callback(it);
        }
    }

    // pending activity
    fun pendingSubjectsByUserID(
        userID: String,
        pensumID: String,
        callback: (List<Subjets>?) -> Unit
    ){
        insRepo.pendingSubjectsByUserID(userID,pensumID){
            callback(it)
        }
    }

    fun getDetailsByIDInscription(
        id: String,
        callback: (List<InscriptionSubjects>?) -> Unit
    ){
        insRepo.getDetailsByIDInscription(id){
            callback(it)
        }
    }
}