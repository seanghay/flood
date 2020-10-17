package com.seanghay.flood.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController

class FeedController : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {

    init {
        Carousel.setDefaultGlobalSnapHelperFactory(null)
    }


    private val models = (0..10).map {
        StoryModel_().id(it)
            .title("Hello")
            .profileUrl("https://i.picsum.photos/id/582/700/700.jpg?hmac=4CuOfOMHziSQ4fSgOXCwPEm5H1Bmzsk-e3jaOMxUSSU")
            .thumbnailUrl("https://i.picsum.photos/id/582/700/700.jpg?hmac=4CuOfOMHziSQ4fSgOXCwPEm5H1Bmzsk-e3jaOMxUSSU")
    }

    override fun buildModels() {
        storyCarousel {
            id("carousels")
            models(models)
            hasFixedSize(true)
            numViewsToShowOnScreen(4.2f)
            padding(
                Carousel.Padding.dp(
                    28,
                    14,
                    28,
                    16,
                    10
                )
            )
        }
        repeat(10) {
            editor {
                id("editor#$it")
            }
        }

    }
}