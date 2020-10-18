package com.seanghay.flood.epoxy

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.bumptech.glide.Glide
import com.google.android.material.card.MaterialCardView
import com.seanghay.flood.R
import com.seanghay.flood.common.load
import com.seanghay.flood.databinding.ComponentEditorBinding

@EpoxyModelClass(layout = R.layout.component_editor)
abstract class EditorModel : EpoxyModel<MaterialCardView>() {

    private lateinit var binding: ComponentEditorBinding

    @EpoxyAttribute
    open var profileUrl: String? = null

    override fun bind(view: MaterialCardView) {
        binding = ComponentEditorBinding.bind(view)
        binding.imageViewProfile.load(profileUrl)
    }
}