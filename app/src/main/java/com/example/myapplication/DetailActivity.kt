package com.example.myapplication
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.os.Bundle
import com.example.myapplication.databinding.ActivityDetailBinding


import com.example.myapplication.model.Pizza

class DetailActivity: AppCompatActivity(){

    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val pizza = intent.extras?.getSerializable("Dodokz") as Pizza

            binding.image.setImageResource(pizza.image)
            binding.title.text = "${pizza.title}"
            binding.description.text = pizza.description
            binding.button.text="To cart for  " + pizza.price.toString() + " TG"

    }

}