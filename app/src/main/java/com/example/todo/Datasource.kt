package com.example.todo

import android.content.Context

class Datasource(private val context: Context) {


    fun loadBooks(): List<Book> {

        val books: MutableList<Book> = mutableListOf()

        val resources = context.resources
        val titles = resources.getStringArray(R.array.titles)
        val descriptions = resources.getStringArray(R.array.descriptions)

        val typedArrayImages = resources.obtainTypedArray(R.array.images)
        val imageCount = titles.size
        val imageResIds = IntArray(imageCount)

        for (i in 0 until imageCount) {
            imageResIds[i] = typedArrayImages.getResourceId(i, 0)
            books.add(Book(titles[i], descriptions[i], imageResIds[i]))
        }

        typedArrayImages.recycle()

        return books
    }
}