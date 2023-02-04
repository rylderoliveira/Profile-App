package com.impacta.firstappkotlin.ui.profile.dogs

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.model.Dog

class DogAdapter : RecyclerView.Adapter<DogViewHolder>() {

    var items: List<Dog> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_dog, parent, false)
        return DogViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: DogViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
