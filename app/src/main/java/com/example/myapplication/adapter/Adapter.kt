package com.example.myapplication.adapter
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.myapplication.databinding.PizzaBinding
import com.example.myapplication.model.Pizza
import androidx.recyclerview.widget.RecyclerView
import android.util.Log


class Adapter(
    private var  PizzaClick: (Pizza) -> Unit ): RecyclerView.Adapter<Adapter.ViewHolder>() {
    private var ListPizza: List<Pizza> = ArrayList()
    companion object {
        private const val PIZZA_ADAPTER_TAG = "PizzaAdapter"
    }
    fun submitList(pizza: List<Pizza>) {
        ListPizza = pizza
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ViewHolder {
        Log.d(PIZZA_ADAPTER_TAG, "onCreateViewHolder")

        return ViewHolder(
            PizzaBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun getItemCount(): Int {
        return ListPizza.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d(PIZZA_ADAPTER_TAG, "onBindViewHolder: $position")
        val pizza = ListPizza[position]
        holder.bind(pizza)
    }
    inner class ViewHolder(
        private val binding: PizzaBinding)
        : RecyclerView.ViewHolder(binding.root) {

        init { binding.root.setOnClickListener {
                val position = adapterPosition
                if (position != RecyclerView.NO_POSITION) {
                    val pizza = ListPizza[position]
                    PizzaClick(pizza)
                }
            }
        }

        fun bind(pizza: Pizza) {
            with(binding) {
                image.setImageResource(pizza.image)
                title.text = pizza.title
                description.text = pizza.description
                price.text = pizza.price.toString()
                root.setOnClickListener{
                    PizzaClick(pizza)
                }
            }
        }

    }
}