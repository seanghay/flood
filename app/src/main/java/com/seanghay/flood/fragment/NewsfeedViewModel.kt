package com.seanghay.flood.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.seanghay.flood.http.Post
import com.seanghay.flood.http.User
import com.seanghay.flood.http.httpService
import java.util.concurrent.CopyOnWriteArrayList

class NewsfeedViewModel : ViewModel() {

    val posts = liveData {
        emit(httpService.posts())
    }

    val users = liveData {
        emit(httpService.users())
    }

    val postsArrayList: CopyOnWriteArrayList<Post> = CopyOnWriteArrayList<Post>()
    val usersArrayList: CopyOnWriteArrayList<User> = CopyOnWriteArrayList<User>()
}