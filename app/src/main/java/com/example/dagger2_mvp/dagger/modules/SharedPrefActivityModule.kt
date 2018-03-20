package com.example.dagger2_mvp.dagger.modules

import com.example.dagger2_mvp.dagger.scopes.ActivityScope
import com.example.dagger2_mvp.views.shared_pref.SharedPrefScreenContract

import dagger.Module
import dagger.Provides

@Module
class SharedPrefActivityModule(var mView: SharedPrefScreenContract.View) {

    @Provides
    @ActivityScope
    fun provideSharedPrefScreenContractView(): SharedPrefScreenContract.View {
        return mView
    }
}