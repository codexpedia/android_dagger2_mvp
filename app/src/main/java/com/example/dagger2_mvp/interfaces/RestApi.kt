package com.example.dagger2_mvp.interfaces

import com.example.dagger2_mvp.data.Post

import io.reactivex.Observable
import retrofit2.http.GET

interface RestApi {

    //    @GET("/posts")
    //    Call<List<Post>> getPosts();

    @get:GET("/posts")
    val posts: Observable<List<Post>>
}
