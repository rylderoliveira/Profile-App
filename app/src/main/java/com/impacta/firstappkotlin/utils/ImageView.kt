package com.impacta.firstappkotlin.utils

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.setImageFromUrl(url: String) {
    Glide.with(this).load(url).into(this)
}