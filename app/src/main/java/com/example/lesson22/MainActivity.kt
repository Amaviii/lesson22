package com.example.lesson22

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson22.databinding.ActivityMainBinding
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val list = listOf(
            Student("Sara", 41431),
            Student("John", 574243),
            Student("David", 4143141),
        )

        var copyList = list.toMutableList()

        val adapter = StudentAdapter(copyList)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = adapter

        binding?.btnAddRandom?.setOnClickListener {
            copyList.replaceAll{
                it.copy(it.name + Random.nextInt(10).toString())
            }
            adapter.update(copyList)
        }

        binding?.btnReverse?.setOnClickListener {
            copyList = list.toMutableList()
            adapter.update(list)
        }

    }
}