package com.student.unicdastudentsapp.domain.repository

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import com.student.unicdastudentsapp.domain.model.News

class NewsRepository {

    companion object {
        private const val COLNAME = "news";
    }

    private val db = FirebaseFirestore.getInstance()
    private val collection =  db.collection(COLNAME);



    fun getNews() : List<News>{
        val news = mutableListOf<News>();
        getNews(){ s ->
            if (s != null) {
                for (i in s){
                    news.add(i);
                }
            }
        }
        return news;
    }

    private fun getNews(callback: (List<News>?) -> Unit ){
        collection.whereEqualTo("active",true)
            .orderBy("date", Query.Direction.DESCENDING)
            .get()
            .addOnSuccessListener { documents ->
                val news = mutableListOf<News>()
                if(!documents.isEmpty) {
                    for (document in documents) {
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