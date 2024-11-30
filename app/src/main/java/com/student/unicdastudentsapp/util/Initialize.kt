package com.student.unicdastudentsapp.util

import android.content.ContentValues.TAG
import android.util.Log
import com.google.firebase.firestore.FirebaseFirestore

class Initialize {
    val db = FirebaseFirestore.getInstance()
    fun init() {
         generatePending()
    }

    private fun generatePensumTest(){
        val curriculum = listOf(
            // Quarter 1
            hashMapOf<String, Any>(

                "code" to "INGS-ALG01",
                "credits" to 4,
                "details" to "Los algoritmos son la base de la informática, ya que son la secuencia de instrucciones que los ordenadores siguen para realizar tareas.",
                "name" to "Algoritmos",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-POO01",
                "credits" to 4,
                "details" to "La programación orientada a objetos es un paradigma que organiza el software en objetos que interactúan entre sí.",
                "name" to "Programación Orientada a Objetos",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-MAT01",
                "credits" to 4,
                "details" to "Las matemáticas son fundamentales en la ingeniería del software, desde la teoría de algoritmos hasta el análisis de complejidad.",
                "name" to "Matemáticas Discretas",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PSI01",
                "credits" to 3,
                "details" to "La psicología cognitiva aplicada al software se enfoca en cómo los usuarios interactúan con los sistemas y cómo mejorar su experiencia.",
                "name" to "Psicología del Software",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 2
            hashMapOf<String, Any>(
                "code" to "INGS-POO02",
                "credits" to 4,
                "details" to "Los patrones de diseño son soluciones reutilizables a problemas comunes en el desarrollo de software.",
                "name" to "Patrones de Diseño",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-DB01",
                "credits" to 4,
                "details" to "Los sistemas de bases de datos permiten almacenar, organizar y gestionar grandes volúmenes de información de manera eficiente.",
                "name" to "Bases de Datos",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-RE01",
                "credits" to 4,
                "details" to "La ingeniería de requisitos aborda cómo identificar y gestionar las necesidades de los usuarios en un proyecto de software.",
                "name" to "Ingeniería de Requisitos",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SO01",
                "credits" to 4,
                "details" to "El sistema operativo es el software que gestiona el hardware y permite que otros programas se ejecuten.",
                "name" to "Sistemas Operativos",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 3
            hashMapOf<String, Any>(
                "code" to "INGS-IA01",
                "credits" to 4,
                "details" to "La inteligencia artificial busca crear máquinas que puedan aprender, razonar y tomar decisiones similares a los seres humanos.",
                "name" to "Inteligencia Artificial",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-AD01",
                "credits" to 4,
                "details" to "El análisis y diseño de software se enfoca en estructurar y planificar soluciones de software antes de implementarlas.",
                "name" to "Análisis y Diseño de Software",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ALG02",
                "credits" to 4,
                "details" to "El análisis de algoritmos incluye la comparación de su eficiencia y la selección del más adecuado para cada problema.",
                "name" to "Análisis de Algoritmos",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-WEB01",
                "credits" to 4,
                "details" to "El desarrollo web cubre los aspectos técnicos de la creación de sitios y aplicaciones en línea utilizando tecnologías modernas.",
                "name" to "Desarrollo Web",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 4
            hashMapOf<String, Any>(
                "code" to "INGS-MOB01",
                "credits" to 4,
                "details" to "El desarrollo de aplicaciones móviles se enfoca en crear software para dispositivos portátiles como smartphones y tabletas.",
                "name" to "Desarrollo Móvil",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PRG01",
                "credits" to 4,
                "details" to "La programación funcional es un paradigma de programación que evita el uso de variables y promueve el uso de funciones puras.",
                "name" to "Programación Funcional",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SEC01",
                "credits" to 4,
                "details" to "La seguridad informática se ocupa de proteger los sistemas de software y hardware contra amenazas y ataques maliciosos.",
                "name" to "Seguridad Informática",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SI01",
                "credits" to 3,
                "details" to "Los sistemas de información son esenciales para el manejo, almacenamiento y procesamiento de datos dentro de las organizaciones.",
                "name" to "Sistemas de Información",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 5
            hashMapOf<String, Any>(
                "code" to "INGS-TEST01",
                "credits" to 4,
                "details" to "Las pruebas de software buscan asegurar que las aplicaciones funcionen correctamente y sin errores antes de su lanzamiento.",
                "name" to "Pruebas de Software",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-MET01",
                "credits" to 4,
                "details" to "La metodología ágil es un enfoque flexible y colaborativo para el desarrollo de software, adaptándose a los cambios durante el proceso.",
                "name" to "Metodologías Ágiles",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-UX01",
                "credits" to 4,
                "details" to "La experiencia de usuario (UX) es la disciplina que busca mejorar la satisfacción de los usuarios en el uso de un producto o servicio.",
                "name" to "Experiencia de Usuario",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ARC01",
                "credits" to 4,
                "details" to "La arquitectura de software se encarga de la estructura organizativa de los componentes y su interacción dentro de un sistema.",
                "name" to "Arquitectura de Software",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 6
            hashMapOf<String, Any>(
                "code" to "INGS-CLOUD01",
                "credits" to 4,
                "details" to "El desarrollo de soluciones en la nube permite construir aplicaciones que se ejecutan en servidores remotos, accesibles desde cualquier dispositivo.",
                "name" to "Computación en la Nube",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-BD02",
                "credits" to 4,
                "details" to "Las bases de datos avanzadas incluyen tecnologías como bases de datos NoSQL y optimización de consultas para grandes volúmenes de datos.",
                "name" to "Bases de Datos Avanzadas",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-IA02",
                "credits" to 4,
                "details" to "La inteligencia artificial avanzada incluye áreas como el aprendizaje profundo y las redes neuronales.",
                "name" to "Inteligencia Artificial Avanzada",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SDEV01",
                "credits" to 4,
                "details" to "El desarrollo de software sostenible aborda la creación de aplicaciones que sean fáciles de mantener y escalar a largo plazo.",
                "name" to "Desarrollo de Software Sostenible",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            // Continue with similar structure for quarters 7 to 12

            // Quarter 7
            hashMapOf<String, Any>(
                "code" to "INGS-ARCH01",
                "credits" to 4,
                "details" to "La arquitectura de sistemas distribuidos permite diseñar sistemas en los que los componentes están ubicados en diferentes máquinas.",
                "name" to "Arquitectura de Sistemas Distribuidos",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-CYB01",
                "credits" to 4,
                "details" to "La ciberseguridad estudia las técnicas y herramientas para proteger los sistemas informáticos contra ataques cibernéticos.",
                "name" to "Ciberseguridad",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-MA02",
                "credits" to 4,
                "details" to "Las matemáticas aplicadas en informática abarcan desde el análisis numérico hasta la optimización de algoritmos.",
                "name" to "Matemáticas Aplicadas",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PROG02",
                "credits" to 4,
                "details" to "La programación concurrente permite ejecutar múltiples procesos simultáneamente, mejorando el rendimiento de las aplicaciones.",
                "name" to "Programación Concurrente",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 8
            hashMapOf<String, Any>(
                "code" to "INGS-BD03",
                "credits" to 4,
                "details" to "La administración avanzada de bases de datos incluye la creación, gestión y optimización de bases de datos grandes y distribuidas.",
                "name" to "Administración Avanzada de Bases de Datos",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-DEVOPS01",
                "credits" to 4,
                "details" to "El enfoque DevOps promueve la colaboración entre desarrolladores y equipos de operaciones para optimizar la entrega de software.",
                "name" to "DevOps",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-COG01",
                "credits" to 4,
                "details" to "La computación cognitiva estudia cómo los sistemas pueden aprender y simular procesos de pensamiento humano.",
                "name" to "Computación Cognitiva",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-BLOCK01",
                "credits" to 4,
                "details" to "La tecnología blockchain permite crear sistemas descentralizados y seguros para realizar transacciones digitales.",
                "name" to "Blockchain",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 9
            hashMapOf<String, Any>(
                "code" to "INGS-ML01",
                "credits" to 4,
                "details" to "El aprendizaje automático es un subcampo de la inteligencia artificial que permite a los sistemas aprender de los datos sin programación explícita.",
                "name" to "Aprendizaje Automático",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ARCH02",
                "credits" to 4,
                "details" to "La arquitectura de software avanzada cubre el diseño y gestión de sistemas complejos que deben ser escalables y mantenibles.",
                "name" to "Arquitectura de Software Avanzada",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-UX02",
                "credits" to 4,
                "details" to "La investigación de la experiencia de usuario (UX) busca entender cómo los usuarios interactúan con las aplicaciones para optimizar su interacción.",
                "name" to "Investigación de UX",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-IO01",
                "credits" to 4,
                "details" to "La ingeniería de operaciones (IO) se centra en la mejora de los procesos y la eficiencia en el desarrollo de software.",
                "name" to "Ingeniería de Operaciones",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 10
            hashMapOf<String, Any>(
                "code" to "INGS-DEV02",
                "credits" to 4,
                "details" to "El desarrollo de software para sistemas embebidos cubre la programación y diseño de software para dispositivos con recursos limitados.",
                "name" to "Sistemas Embebidos",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-API01",
                "credits" to 4,
                "details" to "Las interfaces de programación de aplicaciones (APIs) permiten la integración entre diferentes sistemas y plataformas.",
                "name" to "Diseño de APIs",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-AGILE01",
                "credits" to 4,
                "details" to "La gestión ágil de proyectos utiliza enfoques como Scrum para organizar y gestionar proyectos de software de manera flexible.",
                "name" to "Gestión Ágil de Proyectos",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ENTRE01",
                "credits" to 4,
                "details" to "El emprendimiento tecnológico involucra la creación y desarrollo de nuevas empresas de tecnología con un enfoque en la innovación.",
                "name" to "Emprendimiento Tecnológico",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 11
            hashMapOf<String, Any>(
                "code" to "INGS-AI03",
                "credits" to 4,
                "details" to "La inteligencia artificial para la robótica se enfoca en el desarrollo de algoritmos para robots autónomos e inteligentes.",
                "name" to "IA para Robótica",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SCI01",
                "credits" to 4,
                "details" to "La computación científica utiliza modelos matemáticos para resolver problemas complejos en la ingeniería y la ciencia.",
                "name" to "Computación Científica",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PROD01",
                "credits" to 4,
                "details" to "La gestión de productos de software cubre la planificación, desarrollo y lanzamiento de productos tecnológicos.",
                "name" to "Gestión de Productos de Software",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-TESIS01",
                "credits" to 6,
                "details" to "La tesis de grado permite a los estudiantes desarrollar una investigación avanzada sobre un tema relacionado con la ingeniería de software.",
                "name" to "Tesis de Grado",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),

            // Quarter 12
            hashMapOf<String, Any>(
                "code" to "INGS-CLOUD02",
                "credits" to 4,
                "details" to "La computación en la nube avanzada se centra en la optimización de recursos y la gestión de grandes infraestructuras en la nube.",
                "name" to "Computación en la Nube Avanzada",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-BD04",
                "credits" to 4,
                "details" to "El análisis de Big Data permite procesar y analizar grandes volúmenes de datos con tecnologías específicas.",
                "name" to "Big Data",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ML02",
                "credits" to 4,
                "details" to "El aprendizaje profundo es una técnica avanzada de aprendizaje automático utilizada en el reconocimiento de imágenes, voz y otros datos.",
                "name" to "Aprendizaje Profundo",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-TECH01",
                "credits" to 4,
                "details" to "El análisis de tendencias tecnológicas estudia las últimas innovaciones y su impacto en el desarrollo de software.",
                "name" to "Tendencias Tecnológicas",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ"
            )
        )

        for (i in curriculum) {
            db.collection("subjects")
                .add(i)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }

    private fun generateEventTest(){
        val eventList = mutableListOf<HashMap<String, Any>>()

        val event1 = hashMapOf<String, Any>(
            "active" to true,
            "date" to "5-1-2025",
            "dateCreatedUpdated" to "22 de noviembre de 2024, 12:00:00 a.m. UTC-4",
            "day" to 5,
            "event" to "Examen Final",
            "month" to 1,
            "time" to "08:50",
            "year" to 2025
        )

        val event2 = hashMapOf<String, Any>(
            "active" to true,
            "date" to "15-12-2024",
            "dateCreatedUpdated" to "23 de noviembre de 2024, 12:00:00 a.m. UTC-4",
            "day" to 15,
            "event" to "Conferencia sobre Kotlin",
            "month" to 12,
            "time" to "10:00",
            "year" to 2024
        )

        val event3 = hashMapOf<String, Any>(
            "active" to false,
            "date" to "2-12-2024",
            "dateCreatedUpdated" to "24 de noviembre de 2024, 12:00:00 a.m. UTC-4",
            "day" to 2,
            "event" to "Taller de Desarrollo Móvil",
            "month" to 12,
            "time" to "14:00",
            "year" to 2024
        )

        eventList.add(event1)
        eventList.add(event2)
        eventList.add(event3)

        for (i in eventList) {
            db.collection("events")
                .add(i)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }

    private fun generateNews(){
        val eventList = mutableListOf<HashMap<String, Any>>()

        val event1 = hashMapOf<String, Any>(
            "active" to true,
            "date" to "2024/11/24",
            "img" to 1,
            "link" to "https://unicda.edu.do/educacion-continuada-cierre-de-diplomado-4/",
            "message" to "Con gran entusiasmo y orgullo, celebramos el cierre de varios diplomados y cursos que han sido fundamentales en el desarrollo profesional de nuestros participantes.",
            "title" to "Cierre de diplomados"
        )

        val event2 = hashMapOf<String, Any>(
            "active" to true,
            "date" to "2024/11/22",
            "img" to 2,
            "link" to "https://unicda.edu.do/unicda-y-helados-bon-firman-convenio-de-cooperacion-para-impulsar-el-desarrollo-academico-y-profesional-2/",
            "message" to "La Universidad Domínico Americano (UNICDA) y Helados BON han firmado un importante convenio de cooperación con el objetivo de fortalecer el intercambio de conocimientos y experiencias entre sus estudiantes y profesionales.",
            "title" to "Convenio UNICDA-Helados BON"
        )

        eventList.add(event1)
        eventList.add(event2)

        for (i in eventList) {
            db.collection("news")
                .add(i)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }

    private fun generateCourses(){
        val courseList = mutableListOf<HashMap<String, Any>>()

// First course entry
        val course1 = hashMapOf<String, Any>(
            "Day1" to "Viernes",
            "Day2" to "Sabado",
            "Exam1" to 20,
            "Exam2" to 20,
            "FinalExam" to 20,
            "Homeworks" to 30,
            "Hora1" to "06:00-08:00 p.m",
            "Hora2" to "10:00-12:00 a.m",
            "Subject" to "mi subject",
            "classroom" to "E-105",
            "inscriptionID" to "LnMCKD1hHrmeZB9PjtAD",
            "isCompleted" to false,
            "isRetired" to false,
            "teachEmail" to "angelroy@unictest.edu.do",
            "teacherID" to "Angelo Roy"
        )

// Second course entry
        val course2 = hashMapOf<String, Any>(
            "Day1" to "Martes",
            "Day2" to "Jueves",
            "Exam1" to 15,
            "Exam2" to 10,
            "FinalExam" to 18,
            "Homeworks" to 28,
            "Hora1" to "06:00-08:00 a.m",
            "Hora2" to "06:00-09:00 p.m",
            "Subject" to "Math2024",
            "classroom" to "B-202",
            "inscriptionID" to "LnMCKD1hHrmeZB9PjtAD",
            "isCompleted" to true,
            "isRetired" to false,
            "teachEmail" to "mathteacher@university.edu",
            "teacherID" to "Carlos Mendoza"
        )


        courseList.add(course1)
        courseList.add(course2)
        for (i in  courseList) {
            db.collection("InscriptionSubjects")
                .add(i)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }

    }

    private fun generatePending(){
        val curriculum = listOf(
            // Quarter 1
            hashMapOf<String, Any>(

                "code" to "INGS-ALG01",
                "credits" to 4,
                "details" to "Los algoritmos son la base de la informática, ya que son la secuencia de instrucciones que los ordenadores siguen para realizar tareas.",
                "name" to "Algoritmos",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-POO01",
                "credits" to 4,
                "details" to "La programación orientada a objetos es un paradigma que organiza el software en objetos que interactúan entre sí.",
                "name" to "Programación Orientada a Objetos",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-MAT01",
                "credits" to 4,
                "details" to "Las matemáticas son fundamentales en la ingeniería del software, desde la teoría de algoritmos hasta el análisis de complejidad.",
                "name" to "Matemáticas Discretas",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PSI01",
                "credits" to 3,
                "details" to "La psicología cognitiva aplicada al software se enfoca en cómo los usuarios interactúan con los sistemas y cómo mejorar su experiencia.",
                "name" to "Psicología del Software",
                "quarter" to 1,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 2
            hashMapOf<String, Any>(
                "code" to "INGS-POO02",
                "credits" to 4,
                "details" to "Los patrones de diseño son soluciones reutilizables a problemas comunes en el desarrollo de software.",
                "name" to "Patrones de Diseño",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-DB01",
                "credits" to 4,
                "details" to "Los sistemas de bases de datos permiten almacenar, organizar y gestionar grandes volúmenes de información de manera eficiente.",
                "name" to "Bases de Datos",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-RE01",
                "credits" to 4,
                "details" to "La ingeniería de requisitos aborda cómo identificar y gestionar las necesidades de los usuarios en un proyecto de software.",
                "name" to "Ingeniería de Requisitos",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SO01",
                "credits" to 4,
                "details" to "El sistema operativo es el software que gestiona el hardware y permite que otros programas se ejecuten.",
                "name" to "Sistemas Operativos",
                "quarter" to 2,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 3
            hashMapOf<String, Any>(
                "code" to "INGS-IA01",
                "credits" to 4,
                "details" to "La inteligencia artificial busca crear máquinas que puedan aprender, razonar y tomar decisiones similares a los seres humanos.",
                "name" to "Inteligencia Artificial",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-AD01",
                "credits" to 4,
                "details" to "El análisis y diseño de software se enfoca en estructurar y planificar soluciones de software antes de implementarlas.",
                "name" to "Análisis y Diseño de Software",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ALG02",
                "credits" to 4,
                "details" to "El análisis de algoritmos incluye la comparación de su eficiencia y la selección del más adecuado para cada problema.",
                "name" to "Análisis de Algoritmos",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-WEB01",
                "credits" to 4,
                "details" to "El desarrollo web cubre los aspectos técnicos de la creación de sitios y aplicaciones en línea utilizando tecnologías modernas.",
                "name" to "Desarrollo Web",
                "quarter" to 3,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 4
            hashMapOf<String, Any>(
                "code" to "INGS-MOB01",
                "credits" to 4,
                "details" to "El desarrollo de aplicaciones móviles se enfoca en crear software para dispositivos portátiles como smartphones y tabletas.",
                "name" to "Desarrollo Móvil",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PRG01",
                "credits" to 4,
                "details" to "La programación funcional es un paradigma de programación que evita el uso de variables y promueve el uso de funciones puras.",
                "name" to "Programación Funcional",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SEC01",
                "credits" to 4,
                "details" to "La seguridad informática se ocupa de proteger los sistemas de software y hardware contra amenazas y ataques maliciosos.",
                "name" to "Seguridad Informática",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SI01",
                "credits" to 3,
                "details" to "Los sistemas de información son esenciales para el manejo, almacenamiento y procesamiento de datos dentro de las organizaciones.",
                "name" to "Sistemas de Información",
                "quarter" to 4,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 5
            hashMapOf<String, Any>(
                "code" to "INGS-TEST01",
                "credits" to 4,
                "details" to "Las pruebas de software buscan asegurar que las aplicaciones funcionen correctamente y sin errores antes de su lanzamiento.",
                "name" to "Pruebas de Software",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-MET01",
                "credits" to 4,
                "details" to "La metodología ágil es un enfoque flexible y colaborativo para el desarrollo de software, adaptándose a los cambios durante el proceso.",
                "name" to "Metodologías Ágiles",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-UX01",
                "credits" to 4,
                "details" to "La experiencia de usuario (UX) es la disciplina que busca mejorar la satisfacción de los usuarios en el uso de un producto o servicio.",
                "name" to "Experiencia de Usuario",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ARC01",
                "credits" to 4,
                "details" to "La arquitectura de software se encarga de la estructura organizativa de los componentes y su interacción dentro de un sistema.",
                "name" to "Arquitectura de Software",
                "quarter" to 5,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 6
            hashMapOf<String, Any>(
                "code" to "INGS-CLOUD01",
                "credits" to 4,
                "details" to "El desarrollo de soluciones en la nube permite construir aplicaciones que se ejecutan en servidores remotos, accesibles desde cualquier dispositivo.",
                "name" to "Computación en la Nube",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-BD02",
                "credits" to 4,
                "details" to "Las bases de datos avanzadas incluyen tecnologías como bases de datos NoSQL y optimización de consultas para grandes volúmenes de datos.",
                "name" to "Bases de Datos Avanzadas",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-IA02",
                "credits" to 4,
                "details" to "La inteligencia artificial avanzada incluye áreas como el aprendizaje profundo y las redes neuronales.",
                "name" to "Inteligencia Artificial Avanzada",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SDEV01",
                "credits" to 4,
                "details" to "El desarrollo de software sostenible aborda la creación de aplicaciones que sean fáciles de mantener y escalar a largo plazo.",
                "name" to "Desarrollo de Software Sostenible",
                "quarter" to 6,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            // Continue with similar structure for quarters 7 to 12

            // Quarter 7
            hashMapOf<String, Any>(
                "code" to "INGS-ARCH01",
                "credits" to 4,
                "details" to "La arquitectura de sistemas distribuidos permite diseñar sistemas en los que los componentes están ubicados en diferentes máquinas.",
                "name" to "Arquitectura de Sistemas Distribuidos",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-CYB01",
                "credits" to 4,
                "details" to "La ciberseguridad estudia las técnicas y herramientas para proteger los sistemas informáticos contra ataques cibernéticos.",
                "name" to "Ciberseguridad",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-MA02",
                "credits" to 4,
                "details" to "Las matemáticas aplicadas en informática abarcan desde el análisis numérico hasta la optimización de algoritmos.",
                "name" to "Matemáticas Aplicadas",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PROG02",
                "credits" to 4,
                "details" to "La programación concurrente permite ejecutar múltiples procesos simultáneamente, mejorando el rendimiento de las aplicaciones.",
                "name" to "Programación Concurrente",
                "quarter" to 7,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 8
            hashMapOf<String, Any>(
                "code" to "INGS-BD03",
                "credits" to 4,
                "details" to "La administración avanzada de bases de datos incluye la creación, gestión y optimización de bases de datos grandes y distribuidas.",
                "name" to "Administración Avanzada de Bases de Datos",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-DEVOPS01",
                "credits" to 4,
                "details" to "El enfoque DevOps promueve la colaboración entre desarrolladores y equipos de operaciones para optimizar la entrega de software.",
                "name" to "DevOps",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-COG01",
                "credits" to 4,
                "details" to "La computación cognitiva estudia cómo los sistemas pueden aprender y simular procesos de pensamiento humano.",
                "name" to "Computación Cognitiva",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-BLOCK01",
                "credits" to 4,
                "details" to "La tecnología blockchain permite crear sistemas descentralizados y seguros para realizar transacciones digitales.",
                "name" to "Blockchain",
                "quarter" to 8,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 9
            hashMapOf<String, Any>(
                "code" to "INGS-ML01",
                "credits" to 4,
                "details" to "El aprendizaje automático es un subcampo de la inteligencia artificial que permite a los sistemas aprender de los datos sin programación explícita.",
                "name" to "Aprendizaje Automático",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ARCH02",
                "credits" to 4,
                "details" to "La arquitectura de software avanzada cubre el diseño y gestión de sistemas complejos que deben ser escalables y mantenibles.",
                "name" to "Arquitectura de Software Avanzada",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-UX02",
                "credits" to 4,
                "details" to "La investigación de la experiencia de usuario (UX) busca entender cómo los usuarios interactúan con las aplicaciones para optimizar su interacción.",
                "name" to "Investigación de UX",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-IO01",
                "credits" to 4,
                "details" to "La ingeniería de operaciones (IO) se centra en la mejora de los procesos y la eficiencia en el desarrollo de software.",
                "name" to "Ingeniería de Operaciones",
                "quarter" to 9,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 10
            hashMapOf<String, Any>(
                "code" to "INGS-DEV02",
                "credits" to 4,
                "details" to "El desarrollo de software para sistemas embebidos cubre la programación y diseño de software para dispositivos con recursos limitados.",
                "name" to "Sistemas Embebidos",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-API01",
                "credits" to 4,
                "details" to "Las interfaces de programación de aplicaciones (APIs) permiten la integración entre diferentes sistemas y plataformas.",
                "name" to "Diseño de APIs",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-AGILE01",
                "credits" to 4,
                "details" to "La gestión ágil de proyectos utiliza enfoques como Scrum para organizar y gestionar proyectos de software de manera flexible.",
                "name" to "Gestión Ágil de Proyectos",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ENTRE01",
                "credits" to 4,
                "details" to "El emprendimiento tecnológico involucra la creación y desarrollo de nuevas empresas de tecnología con un enfoque en la innovación.",
                "name" to "Emprendimiento Tecnológico",
                "quarter" to 10,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 11
            hashMapOf<String, Any>(
                "code" to "INGS-AI03",
                "credits" to 4,
                "details" to "La inteligencia artificial para la robótica se enfoca en el desarrollo de algoritmos para robots autónomos e inteligentes.",
                "name" to "IA para Robótica",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-SCI01",
                "credits" to 4,
                "details" to "La computación científica utiliza modelos matemáticos para resolver problemas complejos en la ingeniería y la ciencia.",
                "name" to "Computación Científica",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-PROD01",
                "credits" to 4,
                "details" to "La gestión de productos de software cubre la planificación, desarrollo y lanzamiento de productos tecnológicos.",
                "name" to "Gestión de Productos de Software",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-TESIS01",
                "credits" to 6,
                "details" to "La tesis de grado permite a los estudiantes desarrollar una investigación avanzada sobre un tema relacionado con la ingeniería de software.",
                "name" to "Tesis de Grado",
                "quarter" to 11,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),

            // Quarter 12
            hashMapOf<String, Any>(
                "code" to "INGS-CLOUD02",
                "credits" to 4,
                "details" to "La computación en la nube avanzada se centra en la optimización de recursos y la gestión de grandes infraestructuras en la nube.",
                "name" to "Computación en la Nube Avanzada",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-BD04",
                "credits" to 4,
                "details" to "El análisis de Big Data permite procesar y analizar grandes volúmenes de datos con tecnologías específicas.",
                "name" to "Big Data",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-ML02",
                "credits" to 4,
                "details" to "El aprendizaje profundo es una técnica avanzada de aprendizaje automático utilizada en el reconocimiento de imágenes, voz y otros datos.",
                "name" to "Aprendizaje Profundo",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            ),
            hashMapOf<String, Any>(
                "code" to "INGS-TECH01",
                "credits" to 4,
                "details" to "El análisis de tendencias tecnológicas estudia las últimas innovaciones y su impacto en el desarrollo de software.",
                "name" to "Tendencias Tecnológicas",
                "quarter" to 12,
                "version" to 1, "pensumID" to "ya8i66M8f6BfpqXwIvPZ",
                "pending" to true,
                "studentID" to "4QzCeBSIOVeDduozFLFZ"
            )
        )

        for (i in curriculum) {
            db.collection("pendings")
                .add(i)
                .addOnSuccessListener { documentReference ->
                    Log.d(TAG, "DocumentSnapshot added with ID: ${documentReference.id}")
                }
                .addOnFailureListener { e ->
                    Log.w(TAG, "Error adding document", e)
                }
        }
    }
}