package com.example.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.todo.databinding.FragmentBookDetailBinding


class BookDetailFragment : Fragment() {


    private lateinit var title: String
    private var imageResourceId: Int = 0
    private lateinit var description: String

    private var _binding: FragmentBookDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            title = it.getString(ARG_TITLE).toString()
            imageResourceId = it.getInt(ARG_IMAGE_RESOURCE_ID)
            description = it.getString(ARG_DESCRIPTION).toString()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentBookDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.bookTitle.text = title
        binding.bookDescription.text = description
        binding.bookImage.setImageResource(imageResourceId)
    }

    companion object {
        const val ARG_TITLE = "title"
        const val ARG_IMAGE_RESOURCE_ID = "imageResourceId"
        const val ARG_DESCRIPTION = "description"
    }
//
//    companion object {
//        /**
//         * Use this factory method to create a new instance of
//         * this fragment using the provided parameters.
//         *
//         * @return A new instance of fragment BookDetailFragment.
//         */
//        @JvmStatic
//        fun newInstance(title: String, imageResourceId: Int, description: String) =
//            BookDetailFragment().apply {
//                arguments = Bundle().apply {
//                    putString(ARG_TITLE, title)
//                    putInt(ARG_IMAGE_RESOURCE_ID, imageResourceId)
//                    putString(ARG_DESCRIPTION, description)
//                }
//
}