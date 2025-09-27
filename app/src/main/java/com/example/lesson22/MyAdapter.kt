package com.example.lesson22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson22.databinding.LayoutAuthorTextBinding
import com.example.lesson22.databinding.LayoutImageTextBinding
import com.example.lesson22.databinding.LayoutTextButtonBinding

class MyAdapter(private var items: List<PostsData>) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val TYPE_AUTHOR_TEXT = 0
        private const val TYPE_IMAGE_TEXT = 1
        private const val TYPE_TEXT_BUTTON = 2
    }

    override fun getItemViewType(position: Int): Int {
        return when (items[position]) {
            is PostsData.AuthorText -> TYPE_AUTHOR_TEXT
            is PostsData.ImageText -> TYPE_IMAGE_TEXT
            is PostsData.TextButton -> TYPE_TEXT_BUTTON
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {

            TYPE_AUTHOR_TEXT -> {
                val binding = LayoutAuthorTextBinding.inflate(layoutInflater, parent, false)
                AuthorTextViewHolder(binding)
            }

            TYPE_IMAGE_TEXT -> {
                val binding = LayoutImageTextBinding.inflate(layoutInflater, parent, false)
                ImageTextViewHolder(binding)
            }

            TYPE_TEXT_BUTTON -> {
                val binding = LayoutTextButtonBinding.inflate(layoutInflater, parent, false)
                TextButtonViewHolder(binding)
            }

            else -> throw IllegalArgumentException("Wrong type")
        }
    }

    override fun onBindViewHolder(
        holder: RecyclerView.ViewHolder,
        position: Int
    ) {
        when (holder) {
            is AuthorTextViewHolder -> holder.bind(items[position] as PostsData.AuthorText)
            is ImageTextViewHolder -> holder.bind(items[position] as PostsData.ImageText)
            is TextButtonViewHolder -> holder.bind(items[position] as PostsData.TextButton)
        }
    }

    override fun getItemCount() = items.size

    class AuthorTextViewHolder(private val binding: LayoutAuthorTextBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostsData.AuthorText) {
            binding.authorTv.text = item.name
            binding.authorTextTv.text = item.text
        }
    }

    class ImageTextViewHolder(private val binding: LayoutImageTextBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostsData.ImageText) {
            binding.imageIv.setImageResource(item.imageResId)
            binding.imageTextTv.text = item.text
        }
    }

    class TextButtonViewHolder(private val binding: LayoutTextButtonBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PostsData.TextButton) {
            binding.textButtonTv.text = item.text
        }
    }

    fun updateList(newList: List<PostsData>) {
        val diffResult = DiffUtil.calculateDiff(
            MyCallback(
                oldList = items,
                newList = newList,
            )
        )
        items = newList
        diffResult.dispatchUpdatesTo(this)
    }

}