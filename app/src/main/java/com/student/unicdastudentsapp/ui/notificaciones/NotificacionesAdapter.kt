package com.student.unicdastudentsapp.ui.notificaciones

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.student.unicdastudentsapp.R
import com.student.unicdastudentsapp.ui.data.model.News

class NotificacionesAdapter(private val newsList: List<News>) :

    RecyclerView.Adapter<NotificacionesAdapter.NotificacionesViewHolder>() {

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
        notificacionesViewHolder.title.text = newsList[idx].title
        notificacionesViewHolder.date.text = newsList[idx].date
        notificacionesViewHolder.content.text = newsList[idx].message.substring(0,200) +".."
        notificacionesViewHolder.link.text = newsList[idx].link
        notificacionesViewHolder.image.setImageResource(R.drawable.purplebook)
    }
}