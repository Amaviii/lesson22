package com.example.lesson22

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson22.databinding.LayoutStudentBinding

class StudentAdapter(private var students: MutableList<Student>) : RecyclerView.Adapter<StudentAdapter.StudentViewHolder>() {

    class StudentViewHolder(private val binding: LayoutStudentBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(student: Student) {
            binding.tvStudentName.text = student.name
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): StudentViewHolder {
        val binding = LayoutStudentBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return StudentViewHolder(binding)
    }

    override fun onBindViewHolder(
        holder: StudentViewHolder,
        position: Int
    ) {
        holder.bind(students[position])
    }

    override fun getItemCount(): Int = students.size

    fun update(list: List<Student>){
        val diffResult = DiffUtil.calculateDiff(
            MyDiffUtilCallback(
                oldList = students,
                newList = list.toMutableList()
            )
        )
        students = list.toMutableList()
        diffResult.dispatchUpdatesTo(this)
    }
}