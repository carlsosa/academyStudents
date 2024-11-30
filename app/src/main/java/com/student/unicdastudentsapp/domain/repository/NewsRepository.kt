package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.student.unicdastudentsapp.domain.model.News

class NewsRepository {

    companion object {
        private const val COLNAME = "news";
    }

    fun getNews(callback: (List<News>?) -> Unit ){
        val db = FirebaseFirestore.getInstance()
        val collection =  db.collection(COLNAME);
        collection.whereEqualTo("active",true)
            .orderBy("date", Query.Direction.DESCENDING)
            .get()
            .addOnCompleteListener() { documents ->
                val news = mutableListOf<News>()
                if(documents.isSuccessful) {
                    for (document in documents.result) {
                        val  ps = document.toObject(News::class.java)
                        news.add(ps);
                    }
                    println("Se encontro noticias ")
                    callback(news);
                }else{
                    println("No se encontro noticias ")
                    callback(emptyList());
                }
            }
            .addOnFailureListener { exception ->
                println("Error getting documents: $exception")
            }
    }


}