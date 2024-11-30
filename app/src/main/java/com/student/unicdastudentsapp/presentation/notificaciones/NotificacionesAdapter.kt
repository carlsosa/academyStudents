package com.student.unicdastudentsapp.presentation.notificaciones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.domain.model.News

class NotificacionesAdapter(private val newsList: List<News>) :

    RecyclerView.Adapter<NotificacionesAdapter.NotificacionesViewHolder>() {
    private var onClickListener: NotificacionesAdapter.OnClickListener? = null

    class NotificacionesViewHolder(itemView: View) :
        RecyclerView.ViewHolder(itemView) {
        var title: TextView = itemView.findViewById(R.id.news_title)
        var date: TextView = itemView.findViewById(R.id.news_date)
        var content: TextView = itemView.findViewById(R.id.news_content)
        var link: TextView = itemView.findViewById(R.id.news_link)
        var image: ImageView = itemView.findViewById(R.id.news_image)

    }

    override fun getItemCount(): Int {
        return newsList.size
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): NotificacionesViewHolder {
        val v: View =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.item_news, viewGroup, false)
        return NotificacionesViewHolder(v)
    }

    override fun onBindViewHolder(notificacionesViewHolder: NotificacionesViewHolder, idx: Int) {
        val news = newsList[idx]
        notificacionesViewHolder.title.text = news.title
        notificacionesViewHolder.date.text = news.date
        var length = news.message.length
        if(length > 200){
            length=200
        }
        notificacionesViewHolder.content.text = StringBuilder()
            .append(news.message.substring(0, length)).append("..").toString()
        notificacionesViewHolder.link.text = StringBuilder().append("Haga click para Leer más").toString()
        notificacionesViewHolder.image.setImageResource(R.drawable.news)
        notificacionesViewHolder.itemView.setOnClickListener {
            onClickListener?.onClick(idx, news)
        }

    }

    fun setOnClickListener(listener: OnClickListener?) {
        this.onClickListener = listener
    }

    interface OnClickListener {
        fun onClick(position: Int, model: News)

    }
}