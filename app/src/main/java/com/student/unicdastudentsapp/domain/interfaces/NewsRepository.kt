package com.student.unicdastudentsapp.domain.interfaces

import com.student.unicdastudentsapp.domain.model.News

interface NewsRepository {
    fun getNews(callback: (List<News>?) -> Unit)
}