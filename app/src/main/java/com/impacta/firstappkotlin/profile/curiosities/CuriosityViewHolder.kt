package com.impacta.firstappkotlin.profile.curiosities

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.profile.Curiosity

class CuriosityViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val textViewTitle: TextView = itemView.findViewById(R.id.text_view_item_curiosity_title)
    private val textViewDescription: TextView = itemView.findViewById(R.id.text_view_item_curiosity_description)

    fun bind(curiosity: Curiosity) {
        textViewTitle.text = curiosity.title
        textViewDescription.text = curiosity.description
    }
}
