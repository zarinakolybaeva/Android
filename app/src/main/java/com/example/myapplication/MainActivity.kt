package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Toast
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.model.Pizza
import com.example.myapplication.model.ListPizza
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.adapter.Adapter

class MainActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMainBinding
    private lateinit var actionButton: Button
    private lateinit var adapter: Adapter
    private var PizzaList: List<Pizza> = ListPizza.PizzaList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        actionButton = binding.Button
        handleSearch()
        setupadapter()

    }
    private fun setupadapter() {
        adapter = Adapter { pizza ->
            handlePizzaClick(pizza)
        }
        adapter.submitList(PizzaList)
        binding.recyclerView.adapter = adapter
    }

    private fun filterList() {
        val query = binding.editText.text.toString().trim()
        if (query.isNotEmpty()) {
            val filteredList = PizzaList.filter { it.title.lowercase().contains(query.lowercase()) }
            if (filteredList.isEmpty()) {
                Toast.makeText(this, "Nothing!", Toast.LENGTH_SHORT).show()
            }
            adapter.submitList(ArrayList(filteredList))
        }
        else {
            adapter.submitList(PizzaList)
        }
    }
    private fun handleSearch() {
        binding.Button.setOnClickListener {
            filterList()
        }
    }

    private fun handlePizzaClick(pizza: Pizza) {
        val intent = Intent(this, DetailActivity::class.java)
        intent.putExtra("Dodokz", pizza)
        startActivity(intent)
    }
}