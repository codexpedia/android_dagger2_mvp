package com.example.dagger2_mvp.views.api_call

import com.example.dagger2_mvp.data.Post

interface ApiCallScreenContract {
    interface View {
        fun showPosts(posts: List<Post>)

        fun showError(message: String)

        fun showDownloadComplete()
    }

    interface Presenter {
        fun loadPost()
    }
}