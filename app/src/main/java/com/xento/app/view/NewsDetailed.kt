package com.xento.app.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xento.app.R
import com.xento.app.utils.loadImage
import com.xento.app.view.MainActivity.Companion.seletctedNews
import com.xento.app.viewmodel.BookListViewModel
import com.xento.app.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_news_details.*
import kotlinx.android.synthetic.main.content.*
import kotlinx.android.synthetic.main.toolbar.*

class NewsDetailed : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        profile_id.loadImage(seletctedNews.urlToImage)
        i1.text = seletctedNews.title + " - " + seletctedNews.author + " on " + seletctedNews.publishedAt

        i2.text = seletctedNews.description
        i3.text = seletctedNews.content
        titleHead.text =" News Details"
        backImage.setOnClickListener {
         finish()
        }

    }

}
