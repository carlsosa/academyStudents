package com.student.unicdastudentsapp.domain.use_case

import com.student.unicdastudentsapp.domain.interfaces.NewsRepository
import com.student.unicdastudentsapp.domain.model.News

class NewsUseCase(private val newsRepo: NewsRepository) {
    fun getNews(callback: (List<News>?) -> Unit){
        newsRepo.getNews {
            callback(it)
        }
    }
}