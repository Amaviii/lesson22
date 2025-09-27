package com.example.lesson22

import kotlin.random.Random

sealed class PostsData {

    data class AuthorText(
        val name: String,
        val text: String,
        val id: Int = 432423,
    ) : PostsData()

    data class ImageText(
        val imageResId: Int,
        val text: String,
        val id: Int = 56546,
    ) : PostsData()

    data class TextButton(
        val text: String,
        val id: Int = 76752,
    ) : PostsData()

}