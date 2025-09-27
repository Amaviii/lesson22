package com.example.lesson22

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lesson22.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        //Реализация отступов согласно заданию
        binding?.recyclerView?.addItemDecoration(SpaceItemDecoration(20))

        val list = listOf(
            PostsData.AuthorText("Уильям Шекспир", "Самый известный писатель на земле"),
            PostsData.ImageText(R.drawable.ic_launcher_foreground, "Картинка"),
            PostsData.TextButton("Какой-то текст"),
        )

        val newList = listOf(
            PostsData.AuthorText("Лев Толстой", "Один из самых извсетных писателей на земле"),
            PostsData.ImageText(R.drawable.ic_launcher_foreground, "Картинка"),
            PostsData.TextButton("Текст обновился"),
        )

        val adapter = MyAdapter(list)

        binding?.recyclerView?.layoutManager = LinearLayoutManager(this)
        binding?.recyclerView?.adapter = adapter

        binding?.refreshBtn?.setOnClickListener {
            adapter.updateList(newList)
        }
    }
}