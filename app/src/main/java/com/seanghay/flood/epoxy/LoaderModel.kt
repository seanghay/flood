package com.seanghay.flood.epoxy

import android.graphics.drawable.Drawable
import android.widget.FrameLayout
import androidx.vectordrawable.graphics.drawable.Animatable2Compat
import androidx.vectordrawable.graphics.drawable.AnimatedVectorDrawableCompat
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.seanghay.flood.R
import com.seanghay.flood.databinding.ComponentLoaderBinding

@EpoxyModelClass(layout = R.layout.component_loader)
abstract class LoaderModel : EpoxyModel<FrameLayout>() {

    private lateinit var binding: ComponentLoaderBinding

    override fun bind(view: FrameLayout) {
        binding = ComponentLoaderBinding.bind(view)

        val drawable = AnimatedVectorDrawableCompat.create(
            view.context, R.drawable.avd_anim
        )
        drawable?.registerAnimationCallback(object : Animatable2Compat.AnimationCallback() {
            override fun onAnimationEnd(d: Drawable?) {
                drawable.start()
            }
        })

        drawable?.start()
        binding.imageView.setImageDrawable(drawable)
    }

    override fun unbind(view: FrameLayout) {
    }
}