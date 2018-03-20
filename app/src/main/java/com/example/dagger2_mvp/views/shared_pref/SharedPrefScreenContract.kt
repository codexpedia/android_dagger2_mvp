package com.example.dagger2_mvp.views.shared_pref

interface SharedPrefScreenContract {
    interface View {
        fun showSharedPrefSaveStatus(text: String)
    }

    interface Presenter {
        fun saveToSharedPref(key: String, text: String)

        fun getSavedText(key: String, defaultText: String): String
    }
}