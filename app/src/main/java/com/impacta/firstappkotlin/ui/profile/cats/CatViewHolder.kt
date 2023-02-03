package com.impacta.firstappkotlin.ui.profile.cats

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.model.Cat
import com.impacta.firstappkotlin.utils.setImageFromUrl

class CatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

    private val imageViewCat: ImageView = itemView.findViewById(R.id.image_view_item_cat)
    private val textViewCat: TextView = itemView.findViewById(R.id.text_view_item_cat)

    fun bind(cat: Cat) {
        imageViewCat.setImageFromUrl(cat.url)
        textViewCat.text = cat.id
    }
}
