package com.example.dagger2_mvp.views.shared_pref

import android.content.SharedPreferences

import javax.inject.Inject

class SharedPrefPresenter @Inject
constructor(var sharedPreferences: SharedPreferences, var mView: SharedPrefScreenContract.View) : SharedPrefScreenContract.Presenter {

    override fun saveToSharedPref(key: String, text: String) {
        val ed = sharedPreferences.edit()
        ed.putString(key, text)
        val isSaved = ed.commit()

        mView.showSharedPrefSaveStatus(if (isSaved) "Text Saved!" else "Failed to save the text!")
    }


    override fun getSavedText(key: String, defaultText: String): String {
        return sharedPreferences.getString(key, defaultText)
    }

}