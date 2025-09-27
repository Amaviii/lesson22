package com.example.lesson22

data class Student (
    var name: String,
    val id: Int,
    val rating: Double = 5.0,
) {
}