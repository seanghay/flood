package com.seanghay.flood.epoxy

import android.view.View
import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.google.android.material.card.MaterialCardView
import com.seanghay.flood.R
import com.seanghay.flood.common.load
import com.seanghay.flood.common.shortString
import com.seanghay.flood.common.stringRes
import com.seanghay.flood.databinding.ComponentPostBinding

@EpoxyModelClass(layout = R.layout.component_post)
abstract class PostModel : EpoxyModel<MaterialCardView>() {

    private lateinit var binding: ComponentPostBinding

    @EpoxyAttribute
    open var profileName: CharSequence? = null

    @EpoxyAttribute
    open var profileUrl: String? = null

    @EpoxyAttribute
    open var timeAgo: CharSequence? = null

    @EpoxyAttribute
    open var content: CharSequence? = null

    @EpoxyAttribute
    open var imageUrl: String? = null

    @EpoxyAttribute
    open var likesCount: Int = 0

    @EpoxyAttribute
    open var commentsCount: Int = 0

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    open var photoClickListener: View.OnClickListener? = null

    override fun bind(view: MaterialCardView) {
        binding = ComponentPostBinding.bind(view)
        val resources = view.resources
        with(binding) {
            textViewContent.text = content
            imageViewProfile.load(profileUrl)
            imageView.load(imageUrl)
            imageView.setOnClickListener(photoClickListener)

            textViewName.text = profileName
            textViewDate.text = timeAgo

            textViewLikes.text = stringRes(R.string.likes_count, likesCount.shortString)
            textViewComments.text = stringRes(R.string.comments_count, commentsCount.shortString)

            textViewComments.setOnClickListener {
                // TODO:
            }

            textViewLikes.setOnClickListener {
                // TODO:
            }

            textViewShare.setOnClickListener {
                // TODO:
            }

        }
    }


}