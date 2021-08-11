package com.xento.app.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.xento.app.R
import com.xento.app.model.books.Books
import com.xento.app.model.news.News
import com.xento.app.viewmodel.BookListViewModel
import com.xento.app.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var newsviewModel: NewsViewModel
    lateinit var bookviewModel: BookListViewModel

    private val newsListAdapter = NewsListAdapter(arrayListOf(),this) // news adapter
    private val bookListAdapter = BookListAdapter(arrayListOf(),this) // book adapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       // set News List
        newsviewModel = ViewModelProviders.of(this).get(NewsViewModel::class.java)
        newsviewModel.refresh()
        newsList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsListAdapter
        }
        // set the Book List
        bookviewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
        bookviewModel.refresh()
        bookList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = bookListAdapter
        }

        observeViewModel()
        chickEvent() // Tab selection
    }

    private fun chickEvent() {
        bottomNav.setOnNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_news -> {
                    newsList.visibility = View.VISIBLE
                    bookList.visibility = View.GONE
                    true
                }
                R.id.navigation_books -> {
                    newsList.visibility = View.GONE
                    bookList.visibility = View.VISIBLE
                    true
                }

                else -> false
            }
        }
    }

    fun observeViewModel() {
        newsviewModel.news.observe(this, Observer {countries ->
            countries?.let {
                newsList.visibility = View.VISIBLE
                newsListAdapter.update(it) }
        })

        newsviewModel.newsLoadError.observe(this, Observer { isError ->
            listError.visibility = if(isError == "") View.GONE else View.VISIBLE
        })

        newsviewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    listError.visibility = View.GONE
                    newsList.visibility = View.GONE
                }
            }
        })

        bookviewModel.books.observe(this, Observer {countries ->
            countries?.let {

                bookListAdapter.update(it) }
        })

        bookviewModel.booksLoadError.observe(this, Observer { isError ->
            listError.visibility = if(isError == "") View.GONE else View.VISIBLE
        })

        bookviewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    listError.visibility = View.GONE

                }
            }
        })




    }

   companion object{

       lateinit var seletctedBook: Books
       val mainActivity = MainActivity()
       lateinit var seletctedNews: News
   }
}
