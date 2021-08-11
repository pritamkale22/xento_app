package com.xento.app.view

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.xento.app.R
import com.xento.app.utils.loadImage
import com.xento.app.view.MainActivity.Companion.seletctedBook
import com.xento.app.view.MainActivity.Companion.seletctedNews
import com.xento.app.viewmodel.BookListViewModel
import com.xento.app.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_news_details.*
import kotlinx.android.synthetic.main.content.*
import kotlinx.android.synthetic.main.toolbar.*

class BookDetailedActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_details)
        profile_id.loadImage(seletctedBook.volumeInfo.imageLinks.thumbnail)
        var authors ="";

        if(seletctedBook.volumeInfo.authors !=null)
        for (i in 0..seletctedBook.volumeInfo.authors.size-1) {
            authors = authors +"," +seletctedBook.volumeInfo.authors.get(i)
        }
        i1.text = seletctedBook.volumeInfo.title + " - " + authors + " on "

        i2.text = seletctedBook.volumeInfo.subtitle
        i3.text = seletctedBook.volumeInfo.description
        titleHead.text =" Book Details"
        backImage.setOnClickListener {
            finish()
        }

    }

}
