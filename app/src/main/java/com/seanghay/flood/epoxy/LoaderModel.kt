package com.seanghay.flood.epoxy

import android.widget.FrameLayout
import com.airbnb.epoxy.EpoxyModel
import com.airbnb.epoxy.EpoxyModelClass
import com.seanghay.flood.R

@EpoxyModelClass(layout = R.layout.component_loader)
abstract class LoaderModel: EpoxyModel<FrameLayout>()