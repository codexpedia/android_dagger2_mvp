package com.example.dagger2_mvp.views.api_call

import com.example.dagger2_mvp.interfaces.RestApi
import com.example.dagger2_mvp.data.Post

import javax.inject.Inject

import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.annotations.NonNull
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class ApiCallPresenter @Inject
constructor(var retrofit: Retrofit, var mView: ApiCallScreenContract.View) : ApiCallScreenContract.Presenter {

    override fun loadPost() {
        retrofit.create(RestApi::class.java).posts
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(object : Observer<List<Post>> {
                    override fun onSubscribe(@NonNull d: Disposable) {

                    }

                    override fun onNext(@NonNull posts: List<Post>) {
                        mView.showPosts(posts)
                    }

                    override fun onError(@NonNull e: Throwable) {
                        mView.showError(e.message ?: "Unknown Error")
                    }

                    override fun onComplete() {
                        mView.showDownloadComplete()
                    }
                })

    }

}