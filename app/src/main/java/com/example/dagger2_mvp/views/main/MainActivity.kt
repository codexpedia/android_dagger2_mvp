package com.example.dagger2_mvp.views.main

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.dagger2_mvp.R
import com.example.dagger2_mvp.views.api_call.ApiCallActivity
import com.example.dagger2_mvp.views.shared_pref.SharedPrefActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun openSharedPreferenceExample(v: View) {
        startActivity(Intent(this@MainActivity, SharedPrefActivity::class.java))
    }

    fun openRestApiExample(v: View) {
        startActivity(Intent(this@MainActivity, ApiCallActivity::class.java))
    }

}
