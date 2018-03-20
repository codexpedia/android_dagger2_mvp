package com.example.dagger2_mvp.views.shared_pref

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View

import com.example.dagger2_mvp.MyApp
import com.example.dagger2_mvp.R
import com.example.dagger2_mvp.dagger.modules.SharedPrefActivityModule
import kotlinx.android.synthetic.main.activity_shared_pref.*

import javax.inject.Inject

class SharedPrefActivity : AppCompatActivity(), SharedPrefScreenContract.View {

    @Inject
    lateinit var sharedPrefPresenter: SharedPrefPresenter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shared_pref)

        (application as MyApp).myAppComponent!!
                .addSharedPrefActivityComponent(SharedPrefActivityModule(this))
                .inject(this)

    }

    fun save(v: View) {
        val text = ed_text.text.toString()
        sharedPrefPresenter!!.saveToSharedPref(TEXT_KEY, text)
    }

    fun retrieve(v: View) {
        val savedText = sharedPrefPresenter!!.getSavedText(TEXT_KEY, "")
        tv_display.text = savedText
    }


    override fun showSharedPrefSaveStatus(text: String) {
        Snackbar.make(ed_text, text, Snackbar.LENGTH_SHORT).setAction("Action", null).show()
    }

    companion object {
        private val TEXT_KEY = "text_key"
    }

}
