package com.example.dagger2_mvp.dagger.modules

import android.app.Application
import android.content.Context

import com.example.dagger2_mvp.dagger.scopes.ApplicationScope

import dagger.Module
import dagger.Provides

@Module
class MyAppModule(application: Application) {

    private val mAppContext: Context

    init {
        mAppContext = application
    }

    @Provides
    @ApplicationScope
    fun providesMyAppContext(): Context {
        return mAppContext
    }
}