package com.impacta.firstappkotlin.ui.profile.cats

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.model.Cat

class CatAdapter : RecyclerView.Adapter<CatViewHolder>() {

    var items: List<Cat> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_cat, parent, false)
        return CatViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: CatViewHolder, position: Int) {
        holder.bind(items[position])
    }
}
