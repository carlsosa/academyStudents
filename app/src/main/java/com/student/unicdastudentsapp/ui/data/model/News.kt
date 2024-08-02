package com.student.unicdastudentsapp.ui.data.model

import com.student.unicdastudentsapp.R
import java.io.Serializable

data class News(val id: Long, val message: String, val title: String) : Serializable{
    var img: Int = 0
    var date :String =""
    var link :String =""

    fun getNews() :List<News> {
        var date_i = "Julio 2024"
        var list = mutableListOf<News>();
        var x = News(1,
            "Santo Domingo, martes 23 de julio 2024. El Instituto Cultural Domínico Americano (ICDA), y el Ministerio de Educación Superior, Ciencia y Tecnología (MESCYT), anunciaron la entrega de 1,000 becas para estudiar inglés en modalidad virtual",
            "El ICDA y el MESCYT otorgan becas para estudiar inglés")
        x.date = "Julio 2024"
        x.img = R.drawable.mescyt
        x.link="https://unicda.edu.do/el-instituto-cultural-dominico-americano-y-el-mescyt-otorgan-1000-becas-para-estudiar-ingles-en-cuatro-provincias-de-republica-dominicana/"
        var x1 = News(2,
            "la Universidad Domínico Americano (UNICDA) ha celebrado con éxito su evento UniXperience, consolidándose como un punto de encuentro para estudiantes apasionados y comprometidos con su formación académica",
            "Éxito Total en UniXperience: UNICDA")
        x1.date = date_i
        x1.img = R.drawable.experience
        x1.link="https://unicda.edu.do/exito-total-en-unixperience/"
        var x3 = News(3, "Los participantes de nuestro diplomado vivieron una experiencia educativa en Caucedo DP World Logistics ampliando sus conocimientos académicos con una experiencia práctica de conocer la logística marítima","Práctica de Campo del Diplomado Logística del Comercio Internacional")
        x3.date= date_i
        x3.img = R.drawable.taller
        x3.link="https://unicda.edu.do/diplomado-logistica-del-comercio-internacional/"
        list.add(x)
        list.add(x1)
        list.add(x3)
        return list;
    }
}

