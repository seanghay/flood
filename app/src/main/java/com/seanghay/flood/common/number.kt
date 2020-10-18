package com.seanghay.flood.common

import kotlin.math.abs

val Int.shortString: CharSequence
    get() {
        return when {
            abs(this / 1000000) > 1 -> (this / 1000000).toString() + "m"
            abs(this / 1000) > 1 -> (this / 1000).toString() + "k"
            else -> toString()
        }
    }