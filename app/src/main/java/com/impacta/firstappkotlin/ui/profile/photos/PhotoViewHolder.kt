package com.impacta.firstappkotlin.ui.profile.photos

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.ui.profile.Photo
import com.impacta.firstappkotlin.utils.setImageFromUrl

class PhotoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val imageViewPhoto: ImageView = itemView.findViewById(R.id.image_view_item_photo)
    private val textViewPhoto: TextView = itemView.findViewById(R.id.text_view_item_photo)

    fun bind(photo: Photo) {
        imageViewPhoto.setImageFromUrl(photo.image)
        textViewPhoto.text = photo.description
    }
}
