package com.example.lesson22

import androidx.recyclerview.widget.DiffUtil

class MyCallback(private val oldList: List<PostsData>, private val newList: List<PostsData>) : DiffUtil.Callback() {
    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]

        return when {
            oldItem is PostsData.AuthorText && newItem is PostsData.AuthorText ->
                oldItem.id == newItem.id
            oldItem is PostsData.ImageText && newItem is PostsData.ImageText ->
                oldItem.id == newItem.id
            oldItem is PostsData.TextButton && newItem is PostsData.TextButton ->
                oldItem.id == newItem.id
            else -> false
        }
    }

    override fun areContentsTheSame(
        oldItemPosition: Int,
        newItemPosition: Int
    ): Boolean {
        return oldList[oldItemPosition] == newList[newItemPosition]
    }

}