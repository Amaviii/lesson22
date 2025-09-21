package com.example.lesson22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson22.databinding.StudentsLayoutBinding

class MyAdapter(private val students: List<Student>) : RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(val binding: StudentsLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvName.text = student.name
            var rating: Double = student.rating
            binding.tvRating.text = rating.toString()
            binding.tvRating.setOnClickListener {
                rating = rating + 0.01
                binding.tvRating.text = rating.toString()
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = StudentsLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(students[position])
    }

    override fun getItemCount() = students.size
}