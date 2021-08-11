package com.xento.app.view

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.xento.app.R
import com.xento.app.model.books.Books

import com.xento.app.utils.loadImage
import kotlinx.android.synthetic.main.item_news.view.*


class BookListAdapter(var books: ArrayList<Books>, var mContext:Context): RecyclerView.Adapter<BookListAdapter.UserViewHolder>() {

    fun update(newbooks: List<Books>) {
        books.clear()
        books.addAll(newbooks)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, p1: Int) = UserViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_book, parent, false)
    )

    override fun getItemCount() = books.size

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(books[position])
        holder.itemView.setOnClickListener {
            val intent = Intent(mContext, BookDetailedActivity::class.java)
            //intent.putExtra()[position]
            MainActivity.seletctedBook = books[position]
            mContext.startActivity(intent)
        }
    }

    class UserViewHolder(view: View): RecyclerView.ViewHolder(view) {

        private val imageView = view.Avatar
        private val name = view.name
        private val info = view.info


        fun bind(books: Books) {
            name.text = books.volumeInfo.title
            info.text = books.volumeInfo.subtitle
            imageView.loadImage(books.volumeInfo.imageLinks.smallThumbnail)
        }
    }
}