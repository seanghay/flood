package com.seanghay.flood.common

import android.graphics.drawable.ColorDrawable
import android.util.Log
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.seanghay.flood.R


fun ImageView.load(url: String?) {
    val colorDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.flood_gray))
    Glide.with(this)
        .load(url)
        .fitCenter()
        .centerCrop()
        .placeholder(colorDrawable)
        .error(colorDrawable)
        .into(this)
}