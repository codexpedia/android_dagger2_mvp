package com.example.dagger2_mvp.views.api_call

import android.os.Bundle
import android.support.annotation.VisibleForTesting
import android.support.test.espresso.IdlingResource
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Toast

import com.example.dagger2_mvp.MyApp
import com.example.dagger2_mvp.R
import com.example.dagger2_mvp.dagger.modules.ApiCallActivityModule
import com.example.dagger2_mvp.data.Post
import com.example.dagger2_mvp.test.EspressoIdlingResource
import kotlinx.android.synthetic.main.activity_api_call.*

import java.util.ArrayList

import javax.inject.Inject

class ApiCallActivity : AppCompatActivity(), ApiCallScreenContract.View {

    internal lateinit var postList: ArrayList<String>
    internal lateinit var postListdapter: ArrayAdapter<String>

    @Inject
    lateinit var apiCallPresenter: ApiCallPresenter


    val countingIdlingResource: IdlingResource
        @VisibleForTesting
        get() = EspressoIdlingResource.idlingResource

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_api_call)

        postList = ArrayList()

        (application as MyApp).myAppComponent!!
                .addApiCallActivityComponent(ApiCallActivityModule(this))
                .inject(this)
    }


    fun apiCall(v: View) {

        //Increment the counter before making a network request
        EspressoIdlingResource.increment()

        apiCallPresenter!!.loadPost()
    }


    override fun showPosts(posts: List<Post>) {
        posts.forEach {
            if (it.title != null ) {
                postList.add(it.title!!)
            }
        }

        postListdapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, postList)
        lv_posts.adapter = postListdapter

        // Decrement after loading the posts
        EspressoIdlingResource.decrement()
    }

    override fun showError(message: String) {
        Toast.makeText(applicationContext, "Error" + message, Toast.LENGTH_SHORT).show()

        // If there is no network connection we get an error and decrement the counter because the call has finished
        EspressoIdlingResource.decrement()
    }

    override fun showDownloadComplete() {
        Toast.makeText(applicationContext, "Complete", Toast.LENGTH_SHORT).show()
    }
}