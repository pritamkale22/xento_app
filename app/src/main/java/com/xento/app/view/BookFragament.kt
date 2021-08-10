package com.xento.app.view

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.xento.app.R
import com.xento.app.view.MainActivity.Companion.mainActivity
import com.xento.app.viewmodel.BookListViewModel
import com.xento.app.viewmodel.NewsViewModel
import kotlinx.android.synthetic.main.activity_main.*

class BookFragament : Fragment() {

    lateinit var viewModel: NewsViewModel

    lateinit var bookviewModel: BookListViewModel
    lateinit var mContext:Context




    //private val bookListAdapter = BookListAdapter(arrayListOf(),mainActivity)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Get the custom view for this fragment layout
        val view = inflater!!.inflate(R.layout.fragment_book,container,false)

        // Get the text view widget reference from custom layout
         val bookListAdapter = BookListAdapter(arrayListOf(),mContext)
        bookviewModel = ViewModelProviders.of(this).get(BookListViewModel::class.java)
        bookviewModel.refresh()

        val bookLists : RecyclerView = view.findViewById<RecyclerView>(R.id.bookList)
        bookLists.apply {
            layoutManager = LinearLayoutManager(mContext)
            adapter = bookListAdapter
        }
        bookviewModel.books.observe(mainActivity, Observer {countries ->
            countries?.let {

                bookListAdapter.updateCountries(it) }
        })

        bookviewModel.booksLoadError.observe(mainActivity, Observer { isError ->
            listError.visibility = if(isError == "") View.GONE else View.VISIBLE
        })

        bookviewModel.loading.observe(mainActivity, Observer { isLoading ->
            isLoading?.let {
                loadingView.visibility = if(it) View.VISIBLE else View.GONE
                if(it) {
                    listError.visibility = View.GONE

                }
            }
        })


        // Return the fragment view/layout
        return view
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onAttach(context: Context) {
        mContext =context
        super.onAttach(context)

      //  super.onAttach(context)
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onDetach() {
        super.onDetach()
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onStop() {
        super.onStop()
    }


}