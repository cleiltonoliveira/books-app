package com.example.todo

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView

class BookAdapter(private val books: List<Book>, private val parentFragment: Fragment) :
    RecyclerView.Adapter<BookAdapter.BookViewHolder>() {

    class BookViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val textViewTitle: Button = view.findViewById(R.id.list_item_title)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {

        val book = books[position]

        holder.textViewTitle.text = book.title


        holder.textViewTitle.setOnClickListener {
            val action =
                BookListFragmentDirections.actionBookListFragmentToBookDetailFragment(
                    title = holder.textViewTitle.text.toString(),
                    description = book.description,
                    imageResourceId = book.imageResourceId
                )
//            holder.view.findNavController().navigate(action)
//           Navigation.findNavController(holder.view).navigate(action)
//            parentFragment.findNavController().navigate(action)
            it.findNavController().navigate(action)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {

        val layout = LayoutInflater
            .from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return BookViewHolder(layout)
    }

    override fun getItemCount() = books.size



}