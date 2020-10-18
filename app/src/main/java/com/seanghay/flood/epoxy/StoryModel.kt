package com.seanghay.flood.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithHolder
import com.bumptech.glide.Glide
import com.seanghay.flood.R
import com.seanghay.flood.common.load
import com.seanghay.flood.databinding.ComponentStoryBinding

@EpoxyModelClass(layout = R.layout.component_story)
abstract class StoryModel : EpoxyModelWithHolder<StoryModel.StoryViewHolder>() {

    @EpoxyAttribute
    open var title: CharSequence? = null

    @EpoxyAttribute
    open var thumbnailUrl: String? = null

    @EpoxyAttribute
    open var profileUrl: String? = null

    @EpoxyAttribute
    open var profileRes: Int? = null

    override fun bind(holder: StoryViewHolder) {
        holder.binding.apply {
            textView.text = title
            textView.isSelected = true
            Glide.with(root)
                .load(profileRes ?: profileUrl)
                .fitCenter()
                .centerCrop()
                .into(imageViewProfile)

            imageViewThumbnail.load(thumbnailUrl)
        }
    }

    override fun unbind(holder: StoryViewHolder) {
        holder.binding.textView.isSelected = false
    }


    class StoryViewHolder : EpoxyHolder() {
        lateinit var binding: ComponentStoryBinding

        override fun bindView(itemView: View) {
            binding = ComponentStoryBinding.bind(itemView)
        }
    }
}