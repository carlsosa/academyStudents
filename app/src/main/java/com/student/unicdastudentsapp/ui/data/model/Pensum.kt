package com.student.unicdastudentsapp.ui.data.model

open class Pensum (){
    var numberOfQuarter = 12;
    var numberOfSubjects = getPensumSoftware().size;


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

}
