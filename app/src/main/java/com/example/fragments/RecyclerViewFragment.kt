package com.example.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.activityandintentandroid15.R
import com.example.activityandintentandroid15.databinding.FragmentRecyclerViewBinding

class RecyclerViewFragment : Fragment(), OnItemClickListener {

    private var _binding: FragmentRecyclerViewBinding? = null
    private val binding: FragmentRecyclerViewBinding get() = _binding!!
    private val images = mutableListOf<Int>()
    private val imagesAdapter = ImagesAdapter(images, this)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentRecyclerViewBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fillImages()
        setupRecyclerView()
    }

    private fun fillImages() {
        images.apply {
            add(R.drawable.image1)
            add(R.drawable.image2)
            add(R.drawable.image3)
            add(R.drawable.image4)
        }
    }

    private fun setupRecyclerView() {
        binding.rvImages.adapter = imagesAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onItemClick(position: Int) {
        images.removeAt(position)
        imagesAdapter.notifyDataSetChanged()
        Toast.makeText(requireContext(), "Clicked", Toast.LENGTH_SHORT).show()
    }
}