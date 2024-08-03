package com.student.unicdastudentsapp.ui.data

import com.applandeo.materialcalendarview.CalendarDay
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.ui.data.model.Event
import com.student.unicdastudentsapp.ui.data.model.News
import com.student.unicdastudentsapp.ui.data.model.Professor
import com.student.unicdastudentsapp.ui.data.model.Student
import com.student.unicdastudentsapp.ui.data.model.Subjets
import java.util.Calendar

class InitRepository {
    var events = mutableListOf<Event>();
    fun getSubjects(): List<Subjets>{
        var sl = mutableListOf<Subjets>();
        var profes = getProfessors()
        // 1st year
        var x1 = Subjets(108,"Fundamentos de Programación",1)
        x1.profesor = profes[0]
        x1.date_hour="Lun-Mi 6:00-8:00 P.M"
        x1.logoId = R.drawable.purplebook

        var x2 = Subjets(109,"Álgebra",1)
        x2.profesor = profes[2]
        x2.date_hour="Mar-Ju 6:00-8:00 P.M"
        x2.logoId = R.drawable.redbook
        var x3= Subjets(110,"Algorítmica y Complejidad",1)
        x3.profesor= profes[1]
        x3.date_hour="Mar-Ju 8:00-10:00 P.M"
        x3.logoId = R.drawable.iconalg
        var x4= Subjets(111,"Análisis matemático",1)
        x4.profesor = profes[3]
        x4.date_hour="Lun-Mi 8:00-10:00 P.M"
        x4.logoId = R.drawable.math
        var x5= Subjets(112,"Arquitectura de computadores",1)
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
    fun getUsers(): List<Student> {
        var x = Student("Carlos","Sosa",1)
        x.email="example@uni.do"
        x.password="123456";
        x.genre="Masculino"

        var x1 = Student("Marta","Clauss",2)
        x1.email="example1@uni.do"
        x1.password="123456";
        x1.genre="Femenino"
        var list = mutableListOf(x,x1)
        list.forEach {
            it.isActive = true
            it.studyField = "Ingenieria Software"
            it.age = 22
            it.date_init="2021-30-1"
            it.profile_image= R.drawable.ic_male_student
            it.current_quarter= 4
            it.pensumID=1
            it.haveDebt = false
            it.SubjectsList = getSubjects()
            it.academicIndex=3.5
            it.date_suspend="2027-30-1"
        }
        return list;
    }
    fun getPensumSoftware ()  : List<Subjets> {
        var sl = mutableListOf<Subjets>();
        // 1st year
        sl.add(Subjets(108,"Fundamentos de Programación",1))
        sl.add(Subjets(109,"Álgebra",1))
        sl.add(Subjets(110,"Algorítmica y Complejidad",1))
        sl.add(Subjets(111,"Análisis matemático",1))
        sl.add(Subjets(112,"Arquitectura de computadores",1))

        sl.add(Subjets(113,"Arquitectura y diseño software",2))
        sl.add(Subjets(114,"Aspectos éticos y sociales",2))
        sl.add(Subjets(115,"Aspectos legales y profesionales",2))
        sl.add(Subjets(116,"Bases de Datos",2))
        sl.add(Subjets(105,"Fundamentos Ingenieria de software",2))


        sl.add(Subjets(117,"Bases de datos avanzadas",3))
        sl.add(Subjets(118,"Cálculo",3))
        sl.add(Subjets(119,"Calidad del software",3))
        sl.add(Subjets(120,"Compresión y Recuperación de Información Multimedia",3))
        sl.add(Subjets(107,"Fundamentos Redes",3))


        // 2nd year
        sl.add(Subjets(210,"Computación",4))
        sl.add(Subjets(211,"Computación Ubicua e Inteligencia Ambiental",4))
        sl.add(Subjets(212,"Computadores",4))
        sl.add(Subjets(213,"Construcción y diseño de interfaces gráficas de usuario",4))
        sl.add(Subjets(209,"Fundamentos de seguridad",4))

        sl.add(Subjets(214,"Creación de Empresas y Gestión Emprendedora",5))
        sl.add(Subjets(215,"Criptografía y Teoría de Códigos",5))
        sl.add(Subjets(216,"Diseño y Desarrollo de Sistemas de Información",5))
        sl.add(Subjets(217,"Ingles Tecnico",5))
        sl.add(Subjets(205,"Fundamentos Físicos de la Informática",5))


        sl.add(Subjets(218,"Estadística",6))
        sl.add(Subjets(219,"Estructura de Computadores",6))
        sl.add(Subjets(220,"Estructura de Datos y Algoritmos",6))
        sl.add(Subjets(221," Ética, Legislación y Profesión",6))
        sl.add(Subjets(204,"  Gestión de proyectos y del riesgo",6))


        // 3th yea3
        sl.add(Subjets(300,"Estructura de datos II",7))
        sl.add(Subjets(301,"Evolución y mantenimiento del software",7))
        sl.add(Subjets(302,"Fundamentos de economía y empresa",7))
        sl.add(Subjets(303," Ética, Legislación y Profesión",7))
        sl.add(Subjets(304," Gestión de recursos digitales",7))

        sl.add(Subjets(305,"Ingeniería de computadores",8))
        sl.add(Subjets(306,"Ingeniería de requisitos y modelado",8))
        sl.add(Subjets(307,"Ingeniería del proceso software y construcción",8))
        sl.add(Subjets(308," Inteligencia artificial",8))
        sl.add(Subjets(309," Introducción a la programación de videojuegos",8))

        sl.add(Subjets(310,"Investigación Operativa",9))
        sl.add(Subjets(311,"Lenguajes formales",9))
        sl.add(Subjets(312,"Lógica y Matemáticas Discretas",9))
        sl.add(Subjets(313," Paralelismol",9))
        sl.add(Subjets(314,"Probabilidad y estadística",9))

        // 4th year
        sl.add(Subjets(400,"Programación concurrente y avanzada",10))
        sl.add(Subjets(401,"Robótica",10))
        sl.add(Subjets(402,"Seguridad de la información",10))
        sl.add(Subjets(403,"Paralelismo",10))
        sl.add(Subjets(404,"Sistemas Concurrentes y Distribuidos",10))

        sl.add(Subjets(405,"Software Libre y Desarrollo Social",11))
        sl.add(Subjets(406,"Teoría de Autómatas y lenguajes formales",11))
        sl.add(Subjets(407,"Traductores de lenguajes de programación",11))
        sl.add(Subjets(408,"Verificación y validación",11))
        sl.add(Subjets(409,"Proyecto Final I",11))

        sl.add(Subjets(410,"Proyecto Final II",12))
        sl.add(Subjets(411,"Ethical Hacking",12))
        sl.add(Subjets(412,"Inteligencia Artificial II",12))
        sl.add(Subjets(413,"Seminario de tecnologia",12))
        sl.add(Subjets(414,"Laboratorio Ethical Hacking",12))
        return sl;
    }
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

    fun getEventDays() : List<CalendarDay>{

        // set calendar
        var calendarDays = mutableListOf<CalendarDay>();

        var calendar = Calendar.getInstance();
        calendar.set(2024,8-1, 8)
        var calendarDay =  CalendarDay(calendar);
        calendarDays.add(calendarDay);
        events.add(Event(calendarDay.calendar.time.date.toString(),"Examen Parcial",calendarDay.calendar.time.toString()))

        var cal1 = Calendar.getInstance();
        cal1.set(2024,8-1, 3)
        var calendarDay1 =  CalendarDay(cal1);
        events.add(Event(calendarDay1.calendar.time.date.toString(),"Examen Parcial 2",calendarDay1.calendar.time.toString()))
        calendarDays.add(calendarDay1);

        var cal2 = Calendar.getInstance();
        cal2.set(2024,8-1, 15)
        var calendarDay2 =  CalendarDay(cal2);
        calendarDays.add(calendarDay2);
        events.add(Event(calendarDay2.calendar.time.date.toString(),"Examen Final",calendarDay2.calendar.time.toString()))

        var cal3 = Calendar.getInstance();
        cal3.set(2024,8-1, 15)
        var calendarDay3 =  CalendarDay(cal2);
        events.add(Event(calendarDay3.calendar.time.date.toString(),"Fin Cuatrimestre",calendarDay3.calendar.time.toString()))

        calendarDays.add(calendarDay3);

        calendarDays.forEach {
            it.imageResource = R.drawable.calendar
            it.labelColor = R.color.teal_700
        }
        return calendarDays;
    }
    fun findEventsByDate(cal: String): List<Event> {
        getEventDays();
        return events.filter { it.date == cal }
    }
}