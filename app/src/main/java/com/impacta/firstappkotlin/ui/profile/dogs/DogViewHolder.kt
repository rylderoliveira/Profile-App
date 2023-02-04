package com.impacta.firstappkotlin.ui.profile.dogs

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.model.Dog
import com.impacta.firstappkotlin.utils.setImageFromUrl

class DogViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val imageViewCat: ImageView = itemView.findViewById(R.id.image_view_item_dog)
    private val textViewCat: TextView = itemView.findViewById(R.id.text_view_item_dog)

    fun bind(dog: Dog) {
        imageViewCat.setImageFromUrl(dog.url)
        textViewCat.text = dog.id
    }
}
