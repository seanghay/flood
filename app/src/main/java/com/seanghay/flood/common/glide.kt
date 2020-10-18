package com.seanghay.flood.common

import android.graphics.drawable.ColorDrawable
import android.widget.ImageView
import androidx.core.content.ContextCompat
import com.bumptech.glide.Glide
import com.seanghay.flood.R


fun ImageView.load(url: String?) {
    val colorDrawable = ColorDrawable(ContextCompat.getColor(context, R.color.flood_gray))
    Glide.with(this)
        .load(url)
        .fitCenter()
        .placeholder(colorDrawable)
        .error(colorDrawable)
        .centerCrop()
        .into(this)
}