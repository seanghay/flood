package com.seanghay.flood.epoxy

import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.airbnb.epoxy.EpoxyModelWithView
import com.google.android.material.card.MaterialCardView
import com.seanghay.flood.R

@EpoxyModelClass(layout = R.layout.component_editor)
abstract class EditorModel : EpoxyModel<MaterialCardView>() {
}