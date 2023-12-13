package com.example.fragments

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.DrawableRes
import androidx.recyclerview.widget.RecyclerView
import com.example.activityandintentandroid15.databinding.ItemImageBinding

class ImagesAdapter(
    private val images: List<Int>,
    private val onItemClickListener: OnItemClickListener
) : RecyclerView.Adapter<ImagesAdapter.ImageViewHolder>() {

    inner class ImageViewHolder(private val binding: ItemImageBinding) :
        RecyclerView.ViewHolder(binding.root) {

        init {
           binding.root.setOnClickListener {
               onItemClickListener.onItemClick(adapterPosition)
           }
        }

        fun onBind(@DrawableRes image: Int) = with(binding) {
            binding.root.setImageResource(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ImageViewHolder {
        val binding = ItemImageBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ImageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ImageViewHolder, position: Int) {
        holder.onBind(images[position])
    }

    override fun getItemCount(): Int {
        return images.size
    }
}