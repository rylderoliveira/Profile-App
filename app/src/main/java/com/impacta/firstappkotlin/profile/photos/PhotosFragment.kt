package com.impacta.firstappkotlin.profile.photos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.impacta.firstappkotlin.R
import com.impacta.firstappkotlin.profile.ProfileActivity
import com.impacta.firstappkotlin.profile.getUser

class PhotosFragment : Fragment() {

    private lateinit var imageViewPhoto: ImageView
    private lateinit var textViewPhoto: TextView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews(view)
        listPhotos()
    }

    private fun initViews(view: View) {
        imageViewPhoto = view.findViewById(R.id.image_view_photos_photo)
        textViewPhoto = view.findViewById(R.id.text_view_photos_description)
    }

    private fun listPhotos() {
        val user = getUser()
        textViewPhoto.text = user.photos[0].description
    }
}