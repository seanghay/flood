package com.seanghay.flood.common

import android.view.View
import androidx.annotation.StringRes
import androidx.viewbinding.ViewBinding

@Suppress("NOTHING_TO_INLINE")
inline fun View.stringRes(@StringRes stringRes: Int): String = resources.getString(stringRes)

@Suppress("NOTHING_TO_INLINE")
inline fun View.stringRes(@StringRes stringRes: Int, vararg args: Any): String =
    resources.getString(stringRes, *args)

@Suppress("NOTHING_TO_INLINE")
inline fun ViewBinding.stringRes(@StringRes stringRes: Int): String = root.resources.getString(stringRes)

@Suppress("NOTHING_TO_INLINE")
inline fun ViewBinding.stringRes(@StringRes stringRes: Int, vararg args: Any): String =
    root.resources.getString(stringRes, *args)
