package com.impacta.firstappkotlin.profile.curiosities

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.profile.getUser

class CuriosityAdapter : RecyclerView.Adapter<CuriosityViewHolder>() {

    private val items = getUser().curiosities

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuriosityViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_curisioty, parent, false)
        return CuriosityViewHolder(view)
    }

    override fun onBindViewHolder(holder: CuriosityViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount(): Int {
        return items.size
    }
}
