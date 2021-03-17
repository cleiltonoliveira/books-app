package com.example.todo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.todo.databinding.FragmentBookListBinding


class BookListFragment : Fragment() {

    private var _binding: FragmentBookListBinding? = null
    private val binding get() = _binding!!
    private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentBookListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {


        val dataset = Datasource(this.requireContext()).loadBooks()

        recyclerView = binding.recyclerView

        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = BookAdapter(dataset, this)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}