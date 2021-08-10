package com.xento.app.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.xento.app.R
import com.xento.app.model.news.News
import com.xento.app.utils.loadImage
import com.xento.app.view.MainActivity.Companion.mainActivity
import com.xento.app.view.MainActivity.Companion.seletctedNews
import kotlinx.android.synthetic.main.item_news.view.*

class NewsListAdapter(var news: ArrayList<News>, var mContext:Context): RecyclerView.Adapter<NewsListAdapter.NewsViewHolder>() {

    fun update(newsNew: List<News>) {
        news.clear()
        news.addAll(newsNew)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = NewsViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
    )

    override fun getItemCount() = news.size

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.bind(news[position])

        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, NewsDetailed::class.java)
            //intent.putExtra()[position]
            seletctedNews = news[position]
            mContext.startActivity(intent)
        }
    }

    class NewsViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.Avatar
        private val newsName = view.name
        private val info = view.info


        fun bind(news: News) {
            newsName.text = news.title
            info.text = news.author
            imageView.loadImage(news.urlToImage)
        }
    }
}