package com.seanghay.flood.epoxy

import com.airbnb.epoxy.Carousel
import com.airbnb.epoxy.EpoxyAsyncUtil
import com.airbnb.epoxy.EpoxyController
import com.airbnb.epoxy.EpoxyModel
import com.seanghay.flood.R
import com.seanghay.flood.common.SAMPLE_PROFILE_URL
import com.seanghay.flood.http.Post
import com.seanghay.flood.http.User
import java.util.concurrent.CopyOnWriteArrayList

class FeedController(
    private val _posts: CopyOnWriteArrayList<Post> = CopyOnWriteArrayList<Post>(),
    private val _users: CopyOnWriteArrayList<User> = CopyOnWriteArrayList<User>()
) : EpoxyController(
    EpoxyAsyncUtil.getAsyncBackgroundHandler(),
    EpoxyAsyncUtil.getAsyncBackgroundHandler()
) {


    var listener: FeedListener? = null

    init {
        Carousel.setDefaultGlobalSnapHelperFactory(null)
        setFilterDuplicates(true)
    }

    fun posts(posts: Collection<Post>) {
        _posts.clear()
        _posts.addAll(posts)
        requestModelBuild()
    }

    fun users(users: Collection<User>) {
        _users.clear()
        _users.addAll(users)
        requestModelBuild()
    }


    override fun buildModels() {
        val models: List<EpoxyModel<*>> =
            if (_users.isEmpty())
                listOf(
                    StoryModel_().id("profile-me")
                        .title("Add Story").profileRes(R.drawable.ic_add)
                        .profileUrl("https://picsum.photos/200/200?random=1000")
                        .thumbnailUrl("https://picsum.photos/300/300?random=1000"),
                    LoaderModel_().id("story-loader")
                )
            else _users.mapIndexed { index, it ->
                if (index == 0)
                    StoryModel_().id("profile-me")
                        .title("Add Story").profileRes(R.drawable.ic_add)
                        .profileUrl("https://picsum.photos/200/200?random=${it.id}")
                        .thumbnailUrl("https://picsum.photos/300/300?random=${it.id}")
                else StoryModel_().id(it.id)
                    .title(it.username)
                    .profileUrl("https://picsum.photos/200/200?random=${it.id}")
                    .thumbnailUrl("https://picsum.photos/300/300?random=${it.id}")
            }

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




        editor {
            id("editor")
            profileUrl(SAMPLE_PROFILE_URL)
        }

        if (_posts.isEmpty()) {
            loader {
                id("loader")
            }
        }


        for (post in _posts) {

            post {

                val imageUrl = "https://picsum.photos/700/400?random=${post.id}"
                id(post.id)
                profileUrl("https://picsum.photos/200/200?random=${post.id}")
                imageUrl(imageUrl)
                content(post.body)
                likesCount((0..1_000_000).random())
                commentsCount((0..1_000_000).random())
                profileName("Ian Payne")
                timeAgo("5 mins ago")
                photoClickListener { _ ->
                    listener?.onPhotoItemClick(imageUrl, post)
                }
            }
        }
    }


    interface FeedListener {
        fun onPhotoItemClick(imageUrl: String, post: Post)
    }
}
