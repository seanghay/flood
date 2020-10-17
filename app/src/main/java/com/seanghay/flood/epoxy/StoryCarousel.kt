package com.seanghay.flood.epoxy

import android.content.Context
import android.graphics.Color
import android.util.AttributeSet
import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.ModelView
import com.seanghay.flood.R

@ModelView(
    defaultLayout = R.layout.component_carousel_story,
    saveViewState = true)
class StoryCarousel: Carousel {

    constructor(context: Context?) : super(context)
    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs)
    constructor(context: Context?, attrs: AttributeSet?, defStyle: Int) : super(
        context,
        attrs,
        defStyle
    )

    init {
        setBackgroundColor(Color.WHITE)
    }

}